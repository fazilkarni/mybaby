package com.mybaby.doctor.vo;

import java.util.Date;

public class DoctorVO {
	private int id;
	private String name;
	private Date date_of_birth;
	private String qualification;
	private Date bachelors_completion_date;
	private String address;
	private String phone;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Date getBachelors_completion_date() {
		return bachelors_completion_date;
	}
	public void setBachelors_completion_date(Date bachelors_completion_date) {
		this.bachelors_completion_date = bachelors_completion_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
