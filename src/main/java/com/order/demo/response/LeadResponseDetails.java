package com.order.demo.response;

import java.util.List;

public class LeadResponseDetails {
	private String status;
	private Object data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "LeadResponseDetails [status=" + status + ", data=" + data + "]";
	}
	
	

}
