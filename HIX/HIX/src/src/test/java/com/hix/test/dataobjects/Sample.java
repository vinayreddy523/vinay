package com.hix.test.dataobjects;

public class Sample {

	private String zipCode;
	private String startDate;
	private boolean visionPlan;
	private boolean dentalPlan;
	private String gender;
	private String dateOfBirth;
	private boolean usesTobacco;
	private String userName;
	private String password;

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isUsesTobacco() {
		return usesTobacco;
	}

	public void setUsesTobacco(boolean usesTobacco) {
		this.usesTobacco = usesTobacco;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isDentalPlan() {
		return dentalPlan;
	}

	public void setDentalPlan(boolean dentalPlan) {
		this.dentalPlan = dentalPlan;
	}

	public boolean isVisionPlan() {
		return visionPlan;
	}

	public void setVisionPlan(boolean visionPlan) {
		this.visionPlan = visionPlan;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setStartDate(String StartDate) {
		this.startDate = StartDate;
	}

	public String getStartDate() {
		return startDate;
	}
}