package com.mybaby.appointment.vo;

import java.util.Date;

import com.mybaby.doctor.vo.DoctorVO;
import com.mybaby.patient.vo.PatientVO;

public class AppointmentVO {
	private int id;
	private Date firstVisit;
	private Date followup;
	private DoctorVO Doctor;
	private PatientVO patient;
	public String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFirstVisit() {
		return firstVisit;
	}
	public void setFirstVisit(Date firstVisit) {
		this.firstVisit = firstVisit;
	}
	public Date getFollowup() {
		return followup;
	}
	public void setFollowup(Date followup) {
		this.followup = followup;
	}
	public DoctorVO getDoctor() {
		return Doctor;
	}
	public void setDoctor(DoctorVO doctor) {
		Doctor = doctor;
	}
	public PatientVO getPatient() {
		return patient;
	}
	public void setPatient(PatientVO patient) {
		this.patient = patient;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	

}
