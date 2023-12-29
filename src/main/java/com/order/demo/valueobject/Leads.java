package com.order.demo.valueobject;

import java.io.Serializable;

import com.order.demo.response.LeadResponseDetails;

public class Leads extends LeadResponseDetails implements Serializable {
	private Integer leadId;
	private String firstName;
	private String lastName;
	private Long mobileNumber;
	private String Gender;
	private String dob;
	private String email;

	
	
	public Integer getLeadId() {
		return leadId;
	}



	public void setLeadId(Integer leadId) {
		this.leadId = leadId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Long getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Items [leadId=" + leadId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", Gender=" + Gender + ", dob=" + dob + ", email=" + email + "]";
	}

}
