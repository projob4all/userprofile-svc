package com.job4all.profile.candidate.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.job4all.profile.candidate.model.UpdateCandidateRequest;
import com.job4all.profile.candidate.model.entity.Candidate;
import com.job4all.profile.candidate.model.entity.util.CountryCodes;
import com.job4all.profile.candidate.repository.CandidateRepository;
import com.job4all.profile.candidate.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.job4all.profile.exception.UserProfileException;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	CountryRepository countryRepository;
	
	@Value("${spring.datasource.username}")
	String posgresUserName;
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);
	
	@Transactional
	public Optional<Candidate> getCandidateById(UUID candidateId) throws UserProfileException{
		Optional<Candidate> candidate = candidateRepository.findById(candidateId);
		if(!candidate.isPresent()) {
			throw new UserProfileException("404", "Candidate " + candidateId + " wasnt found", null, candidateId, HttpStatus.NOT_FOUND, null, logger);
		}
		else {
			return candidate;
		}
	}
	
	@Transactional
	public Candidate createCandidate(Candidate candidate) throws UserProfileException{
		candidate.setCountry(countryRepository.findById(CountryCodes.USA.code()).get());
		candidate.setActive(true);
		candidateRepository.save(candidate);
		return candidate;
	}
	
	@Transactional
	public Candidate updateCandidate(UUID candidateId, Candidate candidate)  throws UserProfileException{
		Optional<Candidate> c=candidateRepository.findById(candidateId);
		if(!c.isPresent()) {
			throw new UserProfileException("404", "Candidate " + candidateId + " wasnt found", null, candidateId, HttpStatus.NOT_FOUND, null, logger);
		}
		BeanUtils.copyProperties(candidate, c.get(),"email","created_on","created_by", "country");
		candidateRepository.save(c.get());
		return c.get();
	}
	
	@Transactional
	public void deleteCandidateById(UUID candidateId) {
		candidateRepository.deleteById(candidateId);
	}
	
}
