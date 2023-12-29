package com.order.demo.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private String code;
    private List<String> messages;
	
	@Override
	public String toString() {
		return "ErrorResponse [code=" + code + ", messages=" + messages + "]";
	}
    
}
