package com.order.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.order.demo.response.ErrorResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeadErrorResponseData {
	private String status;
    private ErrorResponse errorResponse;
	
	@Override
	public String toString() {
		return "LeadErrorResponseData [status=" + status + ", errorResponse=" + errorResponse + "]";
	}
    
    }
