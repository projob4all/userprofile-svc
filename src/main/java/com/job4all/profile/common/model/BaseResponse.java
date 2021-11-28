package com.job4all.profile.common.model;

import lombok.Data;

@Data
public class BaseResponse {
	
	private String code;
	private String message;
	
	
	@Override
	public String toString() {
		return "BaseResponse [code=" + code + ", message=" + message + "]";
	}


	public BaseResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	public BaseResponse() {
		super();
	}
	
	
	
}
