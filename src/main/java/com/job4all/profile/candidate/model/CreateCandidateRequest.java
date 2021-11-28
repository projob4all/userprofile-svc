package com.job4all.profile.candidate.model;

import org.springframework.lang.NonNull;

import com.job4all.profile.common.model.CreateRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CreateCandidateRequest extends CreateRequest {
	
	public CreateCandidateRequest() {
		super();
	}

	@NonNull
	private String email;

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private String phone;
	
	@NonNull
	private String address1;

	private String address2;
	private String address3;
	private String address4;

	private String unit;

	@NonNull
	private String city;

	@NonNull
	private String postalCode;

	@Override
	public String toString() {
		return "CreateCandidateRequest [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3
				+ ", address4=" + address4 + ", unit=" + unit + ", city=" + city + ", postalCode=" + postalCode + "]";
	}

}
