package com.mybaby.communication.email;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.mybaby.appointment.vo.AppointmentVO;
import com.mybaby.feeder.appointments.dao.AppointmentDao;
import com.mybaby.utils.Constants;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingGMailSMTP {
	AppointmentDao AppointmentDao;

	public SendEmailUsingGMailSMTP() {
		AppointmentDao = new AppointmentDao();

	}

	public static void main(String[] args) {
		SendEmailUsingGMailSMTP sendEmailUsingGMailSMTP = new SendEmailUsingGMailSMTP();
		sendEmailUsingGMailSMTP.sendPatientFeedbackAndRatingEmail();
	}

	/**
	* 
	*/
	public void sendPatientFeedbackAndRatingEmail() {
		Date date = new Date();
		System.out.println("current day = "+date);
		long prevDate = date.getTime()-Constants.SEND_PATIENT_FEED_BACK_AFTER*24*60*60*1000;
		Timestamp timestamp = new Timestamp(prevDate);
		String query = "select a.FIRST_VISIT, a.FOLLOWUP, p.NAME as PATIENT,p.EMAIL,p.MOBILE, d.NAME as DOCTOR, p.MOTHER_NAME as mother, p.FATHER_NAME as father, p.gender as sex, dp.FEEDBACK_EMAIL_SENT,d.id as DOCTORID, p.id as PATIENTID  from mybaby.PATIENT p, mybaby.DOCTOR d, mybaby.APPOINTMENTS a, mybaby.DOCTOR_PATIENT dp  where a.FIRST_VISIT>'"+timestamp +"' and a.DOCTORID=d.ID and a.PATIENTID=p.ID and dp.DOCTOR_ID=d.ID and dp.PATIENT_ID=p.ID and dp.FEEDBACK_EMAIL_SENT=0";
		List<AppointmentVO> appointments = AppointmentDao.getAppointment(query);
		Iterator<AppointmentVO> itr = appointments.iterator();

		while (itr.hasNext()) {
			sendEmail(itr.next(), Constants.EMAIL_TYPE_SEND_FOR_FEED_BACK);
		}
		//AppointmentDao.setFeedbackEmailSetFlag(appointments); //Uncomment this before moving this app to production.
	}
	
	/**
	* 1
	*/
	public void sendPatientRemainderEmail() {
		String query = "select a.FIRST_VISIT, a.FOLLOWUP, p.NAME as PATIENT,p.EMAIL,p.MOBILE, d.NAME as DOCTOR, p.MOTHER_NAME as mother, p.FATHER_NAME as father,p.gender as sex, p.age  from mybaby.PATIENT p, mybaby.DOCTOR d, mybaby.APPOINTMENTS a where a.DOCTORID=d.ID and a.PATIENTID=p.ID";
		List<AppointmentVO> appointments = AppointmentDao.getAppointment(query);
		Iterator<AppointmentVO> itr = appointments.iterator();

		while (itr.hasNext()) {
			sendEmail(itr.next(), Constants.EMAIL_TYPE_SEND_RECCONECT);
		}
	}

	/**
	 * This method sends the email to patients
	 */

	private void sendEmail(AppointmentVO appointmentVO, int emailType) {
		String heorshe = "the baby";
		if (appointmentVO.getPatient().getAge() > 3 && appointmentVO.getPatient().getSex().equalsIgnoreCase("m")) {
			heorshe = "he";
		} else if (appointmentVO.getPatient().getAge() > 3
				&& appointmentVO.getPatient().getSex().equalsIgnoreCase("f")) {
			heorshe = "she";
		}
		// Recipient's email ID needs to be mentioned.
		String to = appointmentVO.getPatient().getEmail();// "mujahidh83@gmail.com";//change
															// accordingly

		// Sender's email ID needs to be mentioned
		String from = "kooldoctorzz@gmail.com";//"karni.fazil@gmail.com";// change accordingly
		final String username = "kooldoctorzz@gmail.com";//"karni.fazil@gmail.com";// change accordingly
		final String password = "fzphyvhxoiilqvtg";//"vztffiorfonrupaj";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("From Dr."+appointmentVO.getDoctor().getName());
			message.setContent(getEmailBody(appointmentVO,emailType),"text/html");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	private String getEmailBody(AppointmentVO appointmentVO, int emailType) {
		switch (emailType) {
		case 1:
			return getRemainderEmailBody(appointmentVO);
		case 2:
			return getFeedBackEmailBody(appointmentVO);
		case 3:
			return getReconnectEmailBody(appointmentVO);
		}
		return null;

	}

	private String getRemainderEmailBody(AppointmentVO appointmentVO) {
		String remainder = "<html><body><h2>Hi " + appointmentVO.getPatient().getFather_name()
				+ ",</h2><div>This is Dr. Mujahid, I hope your doing fine. This is a gentle remainder that you have an appointment tomorrow at "
				+ appointmentVO.getFollowup() + " for " + appointmentVO.getPatient().getName()
				+ ". If you are coming please reply to this email with Yes, if not coming with No, if you want to postpone the appoitment let me know the prefered date and time.</div><br><br><div>Thanks and regards,</div><div>Dr. Mujahid.</div></body></html>";
		return remainder;
	}

	private String getFeedBackEmailBody(AppointmentVO appointmentVO) {
		String heorshe = "the baby";
		if (appointmentVO.getPatient().getAge() > 3 && appointmentVO.getPatient().getSex().equalsIgnoreCase("m")) {
			heorshe = "he";
		} else if (appointmentVO.getPatient().getAge() > 3
				&& appointmentVO.getPatient().getSex().equalsIgnoreCase("f")) {
			heorshe = "she";
		}
		String remainder = "<html><body><h2>Hi " + appointmentVO.getPatient().getFather_name()
				+ ",</h2><div>This is Dr. Mujahid, I hope your doing fine. Recently you consulted me regarding your child "
				+ appointmentVO.getPatient().getName() + " and I hope it was a satisfactory meeting. </div><br><div>I am consistently striving to provide excellent services to my patients and with regard to this I would like to improvise by your valuable feedback. So kindly reply to this email answering following queries.</div><br><div>i. How do you rate service/treatment on 1 to 5 scale.</div><div><br><span style='margin-left=50px'>    Very Satisfied = 5, Satisfied = 4, Neutral =3, Dissatisfied = 2, Very Dissatisfied = 1. </span></div><br><div>ii. Any other comments you would like to share : </div><br><br><div>Thanks and regards,</div><div>Dr. Mujahid.</div></body></html>";
		return remainder;
	}

	private String getReconnectEmailBody(AppointmentVO appointmentVO) {
		String heorshe = "the baby";
		if (appointmentVO.getPatient().getAge() > 3 && appointmentVO.getPatient().getSex().equalsIgnoreCase("m")) {
			heorshe = "he";
		} else if (appointmentVO.getPatient().getAge() > 3
				&& appointmentVO.getPatient().getSex().equalsIgnoreCase("f")) {
			heorshe = "she";
		}
		String remainder = "<html><body><h2>Hi " + appointmentVO.getPatient().getFather_name()
				+ ",</h2><div>This is Dr. Mujahid, I hope your doing fine. Recently you consulted me regarding "
				+ appointmentVO.getPatient().getName() + " and I hope " + heorshe
				+ " is recovering well. </div><br><div>If case you need any suggestion or want to know anything regarding "
				+ appointmentVO.getPatient().getName()
				+ "'s recovery do write back to me. I would love to assist you in this regard. </div><br><br><div>Thanks and regards,</div><div>Dr. Mujahid.</div></body></html>";
		return remainder;
	}
}