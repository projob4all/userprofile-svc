package com.job4all.profile.candidate.model;

import org.springframework.lang.NonNull;

import com.job4all.profile.common.model.UpdateRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UpdateCandidateRequest extends UpdateRequest {
	
	public UpdateCandidateRequest() {
		super();
	}

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

	@NonNull
	private Boolean active;

	@Override
	public String toString() {
		return "UpdateCandidateRequest [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", address4="
				+ address4 + ", unit=" + unit + ", city=" + city + ", postalCode=" + postalCode + ", active=" + active
				+ "]";
	}
	
	

}
