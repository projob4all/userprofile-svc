package com.job4all.profile.candidate.model;

import com.job4all.profile.candidate.model.entity.Candidate;
import com.job4all.profile.common.model.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CreateCandidateResponse extends BaseResponse {
	
	private Candidate candidate;

	public CreateCandidateResponse(Candidate candidate, String code, String message) {
		super();
		this.candidate = candidate;
		this.setCode(code);
		this.setMessage(message);
	}

	public CreateCandidateResponse() {
		super();
	}

	@Override
	public String toString() {
		return "CreateCandidateResponse [candidate=" + candidate + ", toString()=" + super.toString() + "]";
	}
	
	

}
