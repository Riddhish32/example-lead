package com.order.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.model.Lead;
import com.order.demo.repository.LeadTableRepository;
import com.order.demo.response.ErrorResponse;
import com.order.demo.response.LeadErrorResponseData;
import com.order.demo.response.LeadResponseDetails;



@RestController
@RequestMapping("/lead")
public class LeadController {

	/*
	 * @Autowired private OrderService orderService;
	 */
	

	
	@Autowired 
	private LeadTableRepository leadTableRepository;
	
	@RequestMapping(value="/createLead", method=RequestMethod.POST)
	public ResponseEntity<?> createLead(@RequestBody Lead lead) {
	//	Lead lead = new Lead();
		
		
		/*Success Response*/
		LeadResponseDetails leadResponseDetails = new LeadResponseDetails();
		leadResponseDetails.setData("Created Leads Successfully");
		leadResponseDetails.setStatus("success");
		
        /*Error Response*/
		LeadErrorResponseData leadErrorResponseData = new LeadErrorResponseData();
		leadErrorResponseData.setStatus("error");
		ErrorResponse errorResponse =  new ErrorResponse();
		errorResponse.setCode("E10010");
		List<String> messages=new ArrayList<String>();
		messages.add("Lead Already Exists in the database with "+lead.getLeadId());
		errorResponse.setMessages(messages);
		leadErrorResponseData.setErrorResponse(errorResponse);
		
		String emailPattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		
		Pattern pattern = Pattern.compile(emailPattern);  
		Matcher matcher = pattern.matcher(lead.getEmail()); 
		
		String mobilePattern="^[6-9]\\\\d{9}$";
		Pattern phPattern = Pattern.compile(mobilePattern);
		Matcher phMatcher = phPattern.matcher(lead.getMobileNumber().toString());
		
		if(lead.getMobileNumber()!=10 || !phMatcher.matches()) {
			return ResponseEntity.ok(leadErrorResponseData);
		}else if(!matcher.matches()) {
			return ResponseEntity.ok(leadErrorResponseData);
		}
		
		try {
			Lead saveLead=leadTableRepository.save(lead);
			Integer saveLeadId = saveLead.getLeadId();
            return ResponseEntity.ok(leadResponseDetails);
        } catch (Exception e) {
        	System.err.println(e);
            return ResponseEntity.ok(leadErrorResponseData);
        }
		
		
		
	}
	
	@GetMapping("/getLeadByMobileNumber/{mobileNumber}")
    public ResponseEntity<?> getLeadByMobileNumber(@PathVariable Long mobileNumber) {
        List<Lead> lead = leadTableRepository.findByMobileNumber(mobileNumber);
        
        /*Success response*/
        LeadResponseDetails leadResonseDetails = new LeadResponseDetails();
        leadResonseDetails.setStatus("success");
        leadResonseDetails.setData(lead);
        
        /*Error Response*/
        LeadErrorResponseData leadErrorResponseData = new LeadErrorResponseData();
        leadErrorResponseData.setStatus("error");
		ErrorResponse errorResponse =  new ErrorResponse();
		errorResponse.setCode("E10011");
		List<String> messages=new ArrayList<String>();
		messages.add("No Lead found with "+	mobileNumber);
		errorResponse.setMessages(messages);
		leadErrorResponseData.setErrorResponse(errorResponse);
        if (lead != null) {
        	
            return ResponseEntity.ok(leadResonseDetails);
        } else {
            return ResponseEntity.ok(leadErrorResponseData);
        }
    }
	
}
