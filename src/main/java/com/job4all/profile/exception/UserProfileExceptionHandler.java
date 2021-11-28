package com.job4all.profile.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.job4all.profile.common.model.BaseResponse;

@ControllerAdvice
public class UserProfileExceptionHandler {
	
	@ExceptionHandler(value = UserProfileException.class)
	public ResponseEntity<BaseResponse> exception(UserProfileException exception) {
		if(exception.getResponse().getCode() == null) {
			exception.setResponse(new BaseResponse(exception.getCode(), exception.getMessage()));
		}
		exception.getLogger().error(exception.toString());
		return new ResponseEntity<BaseResponse>(exception.getResponse(),exception.getHttpstatus());
	}

}
