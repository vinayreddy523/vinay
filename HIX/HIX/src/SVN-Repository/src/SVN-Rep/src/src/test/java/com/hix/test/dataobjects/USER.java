package com.hix.test.dataobjects;

public class USER {

	/*
	 * Data structure. Please note that the order is very important here. If
	 * this order is mismatched with the excel-sheet column, then the data may
	 * not be read correctly, or even fail to read.
	 * 
	 * This is the starting point of our data.
	 */
	private String zipCode;
	private String startDate;
	private Boolean dentalPlan;
	private Boolean visionPlan;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Boolean getDentalPlan() {
		return dentalPlan;
	}

	public void setDentalPlan(Boolean dentalPlan) {
		this.dentalPlan = dentalPlan;
	}

	public Boolean getVisionPlan() {
		return visionPlan;
	}

	public void setVisionPlan(Boolean visionPlan) {
		this.visionPlan = visionPlan;
	}

}
