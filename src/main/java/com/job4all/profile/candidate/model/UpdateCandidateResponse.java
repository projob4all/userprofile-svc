package com.job4all.profile.candidate.model;

import com.job4all.profile.candidate.model.entity.Candidate;
import com.job4all.profile.common.model.BaseResponse;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UpdateCandidateResponse extends BaseResponse {
		private Candidate candidate;

		public UpdateCandidateResponse(String code, String message, Candidate candidate) {
			super(code, message);
			this.candidate = candidate;
		}

		public UpdateCandidateResponse() {
			super();
		}

		public UpdateCandidateResponse(String code, String message) {
			super(code, message);
		}
		
		
}
