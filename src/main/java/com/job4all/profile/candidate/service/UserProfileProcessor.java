package com.job4all.profile.candidate.service;

import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.job4all.profile.candidate.model.*;
import com.job4all.profile.candidate.model.entity.Candidate;
import com.job4all.profile.common.model.BaseResponse;
import com.job4all.profile.common.model.IStatusCode;
import com.job4all.profile.exception.UserProfileException;
import org.slf4j.LoggerFactory;

@Component
public class UserProfileProcessor implements IStatusCode{
	
	@Autowired CandidateService candidateService;
	private static final Logger logger = LoggerFactory.getLogger(UserProfileProcessor.class);
	
	
	public void processError(Exception e, Logger logger, String method, String request, String response){
		String message = (e==null)?"null exception": " message : " + e.getMessage() + " trace : " +  e.getStackTrace() + " cause : " + e.getCause() + " request : " + request +  " response : " + response;
		if(e != null)logger.error("Error : "+ method + e.getMessage() + message, e);
		else logger.error("error : "+method + " null exception");
	}
	
	public void processSuccess(Logger logger, String method, String request, String response) {
		logger.info("Method : " + method + " request : " + request + " response : " + response);
	}
	
	public CreateCandidateResponse processCreateCandidate(CreateCandidateRequest createCandidateRequest) throws UserProfileException {
		Candidate candidate=new Candidate();
		try {
			logger.debug("CreateCandidateRequest : " + createCandidateRequest);
			BeanUtils.copyProperties(createCandidateRequest, candidate);
			candidate = candidateService.createCandidate(candidate);
			CreateCandidateResponse  response = new CreateCandidateResponse(candidate, HTTP_OK, "Candidate was created successfully");
			logger.debug("CreateCandidateResponse : " + response);
			return response;
		}catch(UserProfileException ue){
			CreateCandidateResponse  response = new CreateCandidateResponse(candidate, ue.getCode(), ue.getMessage());
			throw new UserProfileException(GENERIC_ERROR, ue.getMessage(), ue, null, ue.getHttpstatus(), response, logger);
		}catch(Exception e) {
			CreateCandidateResponse  response = new CreateCandidateResponse(candidate, GENERIC_ERROR, e.getMessage());
        	throw new UserProfileException(GENERIC_ERROR, e.getMessage(), e, null, HttpStatus.INTERNAL_SERVER_ERROR, response, logger);
		}
	}
	
	public GetCandidateResponse getCandidateById(UUID uid) throws UserProfileException {
		Optional<Candidate> candidate;
		Candidate c = null;
        try {
        	logger.debug("getCandidateById : " + uid);
        	candidate = candidateService.getCandidateById(uid);
        	c = candidate.get();
        	GetCandidateResponse response = new GetCandidateResponse(candidate.get(),HTTP_OK, "SUCCESS");
        	logger.debug("GetCandidateResponse : " + response);
        	return response;
        }catch(UserProfileException ue) {
        	GetCandidateResponse  response = new GetCandidateResponse(c, ue.getCode(), ue.getMessage());
        	throw new UserProfileException(ue.getCode(), ue.getMessage(), ue, null, ue.getHttpstatus(), response, logger);
        }catch (Exception e) {
        	GetCandidateResponse  response = new GetCandidateResponse(c, GENERIC_ERROR, e.getMessage());
        	throw new UserProfileException(GENERIC_ERROR, e.getMessage(), e, uid, HttpStatus.INTERNAL_SERVER_ERROR, response, logger);
        }
	}
	
	public UpdateCandidateResponse updateCandidate(UpdateCandidateRequest request, UUID uid) throws UserProfileException {
		Candidate c = new Candidate();
		try {
			logger.debug("UpdateCandidateRequest : " + request);
			BeanUtils.copyProperties(request, c);
			c.setCandidateId(uid);
			c = candidateService.updateCandidate(c.getCandidateId(),c);
			var response = new UpdateCandidateResponse(HTTP_OK, "SUCCESS : uid was updated " + c.getCandidateId(), c);
			logger.debug("UpdateCandidateResponse : " + request);
			return response;
        }catch(UserProfileException ue) {
        	UpdateCandidateResponse  response = new UpdateCandidateResponse(ue.getCode(), ue.getMessage(), c);
        	throw new UserProfileException(ue.getCode(), ue.getMessage(), ue, null, ue.getHttpstatus(), response, logger);
        }catch (Exception e) {
        	UpdateCandidateResponse  response = new UpdateCandidateResponse(GENERIC_ERROR, e.getMessage(), c);
        	throw new UserProfileException(GENERIC_ERROR, e.getMessage(), e, null, HttpStatus.INTERNAL_SERVER_ERROR, response, logger);
        }

	}
	
	public BaseResponse deleteCandidateById(UUID uid) throws UserProfileException {
	
		try {
			candidateService.deleteCandidateById(uid);
			BaseResponse response = new BaseResponse(HTTP_OK,"UUID " + uid + " was deleted successfully");
			logger.debug("deleteCandidateById : " + response);
			return response;
        }catch (Exception e) {
        	GetCandidateResponse  response = new GetCandidateResponse(null, GENERIC_ERROR, e.getMessage());
        	throw new UserProfileException(GENERIC_ERROR, e.getMessage(), e, null, HttpStatus.INTERNAL_SERVER_ERROR, response, logger);
        }

		
	}
		


}
