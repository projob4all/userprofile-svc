package com.job4all.profile.candidate.model;

import com.job4all.profile.candidate.model.entity.Candidate;
import com.job4all.profile.common.model.BaseResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class GetCandidateResponse extends BaseResponse{
	private Candidate candidate;

	public GetCandidateResponse(Candidate candidate, String code, String message) {
		super(code, message);
		this.candidate = candidate;
	}
	
	public GetCandidateResponse() {}

}
