package com.job4all.profile.candidate.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.job4all.profile.candidate.model.*;
import com.job4all.profile.candidate.service.UserProfileProcessor;
import com.job4all.profile.common.model.BaseResponse;
import com.job4all.profile.exception.UserProfileException;

@RestController
public class CandidateController {
	
	@Autowired
	UserProfileProcessor candidateProcessor;
	
	@GetMapping(value = "/index")
	public String index() {
        return "userprofile-svc 1.0";
	}

	@GetMapping(value = "/candidate/{candidateId}")
	public ResponseEntity<GetCandidateResponse> getCandidateById(@PathVariable(required=true) UUID candidateId) throws UserProfileException{
        return new ResponseEntity<GetCandidateResponse>(candidateProcessor.getCandidateById(candidateId),HttpStatus.OK);
	}

	@PostMapping(value = "/candidate", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateCandidateResponse> createCandidate(@RequestBody CreateCandidateRequest createCandidateRequest) throws UserProfileException{
		return new ResponseEntity<CreateCandidateResponse>(candidateProcessor.processCreateCandidate(createCandidateRequest),HttpStatus.OK);
	}

	@PutMapping(value = "/candidate/{candidateId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UpdateCandidateResponse> updateCandidate(@PathVariable(required=true) UUID candidateId, @RequestBody UpdateCandidateRequest updateCandidateRequest)  throws UserProfileException{
		return new ResponseEntity<UpdateCandidateResponse>(candidateProcessor.updateCandidate(updateCandidateRequest, candidateId),HttpStatus.OK);
	}

	@DeleteMapping(value = "/candidate/{candidateId}")
	public ResponseEntity<BaseResponse> deleteCandidateById(@PathVariable(required=true) UUID candidateId) throws UserProfileException{
		BaseResponse response = candidateProcessor.deleteCandidateById(candidateId);
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
}