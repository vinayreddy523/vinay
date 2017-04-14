package com.hix.test.dataobjects;

public class Brokers {

	public String firstName;
	public String lastName;
	public String navigatorOrBroker;
	public String idNumber;
	private String userName;
	private String password;
	public String securityAnswer1;
	public String securityAnswer2;
	public String securityAnswer3;



	 public String getSecurityAnswer1() {
	 return securityAnswer1;
	 }

	 public void securityAnswer1(String securityAnswer1) {
	 this.securityAnswer1 = securityAnswer1;
	 }

	 public String getSecurityAnswer2() {
	 return securityAnswer2;
	 }

	 public void securityAnswer2(String securityAnswer2) {
	 this.securityAnswer2 = securityAnswer2;
	 }
	 public String getSecurityAnswer3() {
	 return securityAnswer3;
	 }

	 public void securityAnswer3(String securityAnswer3) {
	 this.securityAnswer3 = securityAnswer3;
	 }
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



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}
	public String getNavigatorOrBroker() {
		return navigatorOrBroker;
	}
	public void setNavigatorOrBroker(String navigatorOrBroker) {
		this.navigatorOrBroker = navigatorOrBroker;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

}