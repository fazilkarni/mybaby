package com.mybaby.feeder.appointments.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mybaby.appointment.vo.AppointmentVO;
import com.mybaby.doctor.vo.DoctorVO;
import com.mybaby.patient.vo.PatientVO;
import com.mysql.jdbc.PreparedStatement;

public class AppointmentDao {
	Connection connection;

	public AppointmentDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybaby", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean importAppointments(List<AppointmentVO> appointments) {
		/*insert into mybaby.PATIENT values(1, 'Ramesh','1983-01-01 00:00:01','Suresh','Suvarna','Andra','9900932583','mujahidh83@gmail.com');
		  insert into mybaby.APPOINTMENTS values(2,'2016-06-04 00:00:01','2016-06-06 00:00:01',1,1,'follow-up');
	 */
		String appointmentsSql = "insert into";
		String patientsInsertSql = "insert into PATIENT (NAME,DATE-OF-BIRTH,FATHER-NAME,MOTHER-NAME,ADDRESS,MOBILE,EMAIL) values(?,?,?,?,?,?,?)";
		String patientsGetSql = "select * from PATIENT where name=? and email=? and phone=?";
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement patientGetPreparedStmt = (PreparedStatement) connection.prepareStatement(patientsGetSql);
			patientGetPreparedStmt.setString(1, "");
			patientGetPreparedStmt.setString(2, "");
			patientGetPreparedStmt.setString(3, "");
			ResultSet rs = patientGetPreparedStmt.executeQuery();
			if(rs.next()){//patient is repeat patient
				
			}else{
				//First insert the patient
				PreparedStatement patientInsertStmt = (PreparedStatement) connection.prepareStatement(patientsInsertSql);
				patientInsertStmt.setString(1, "");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<AppointmentVO> getAppointment(String query){
		AppointmentVO appointment = new AppointmentVO();
		List<AppointmentVO> appointments = new ArrayList<AppointmentVO>();
		try {
			Statement stmnt = connection.createStatement();
			ResultSet rs = stmnt.executeQuery(query);
			while(rs.next()){
				appointment = new AppointmentVO(); 
				DoctorVO doctor = new DoctorVO();
				doctor.setName(rs.getString(6));
				PatientVO patient = new PatientVO();
				patient.setEmail(rs.getString(4));
				patient.setName(rs.getString(3));
				patient.setMobile(rs.getString(5));
				patient.setMother_name(rs.getString(7));
				patient.setFather_name(rs.getString(8));
				patient.setSex(rs.getString(9));
				patient.setAge(rs.getInt(10));
				appointment.setDoctor(doctor);
				appointment.setPatient(patient);
				appointment.setFirstVisit(new Date(rs.getLong(1)));
				appointment.setFollowup(new Date(rs.getLong(2)));
				appointments.add(appointment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return appointments;
	}

}