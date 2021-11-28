package com.job4all.profile.exception;

import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;

import com.job4all.profile.candidate.model.GetCandidateResponse;
import com.job4all.profile.common.model.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserProfileException  extends Exception {

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private Exception e;
	private UUID uid;
	private BaseResponse response;
	private HttpStatus httpstatus;
	private Logger logger;
	
	public UserProfileException(String code, String message, Exception e, UUID uid, HttpStatus httpstatus, BaseResponse response, Logger logger) {
		super(message);
		this.code = code;
		this.message = message;
		this.e = e;
		this.uid = uid;
		this.httpstatus = httpstatus;
		this.response = response;
		this.logger = logger;
	}
	
	public UserProfileException() {
	}

	@Override
	public String toString() {
		return "UserProfileException [code=" + code + ", message=" + message + ", e=" + e + ", uid=" + uid
				+ ", response=" + response + ", httpstatus=" + httpstatus + "]";
	}

	
	
}
