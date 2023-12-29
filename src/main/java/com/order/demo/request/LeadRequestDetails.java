package com.order.demo.request;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class LeadRequestDetails {
	private Integer leadId;
	private String firstName;
	private String lastName;
	private Integer mobileNumber;
	private String Gender;
	private String dob;
	private String email;

	

	@Override
	public String toString() {
		return "LeadRequestDetails [leadId=" + leadId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", Gender=" + Gender + ", dob=" + dob + ", email=" + email + "]";
	}
}
