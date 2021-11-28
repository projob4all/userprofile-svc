package com.job4all.profile.candidate.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.job4all.profile.candidate.model.CreateCandidateRequest;
import com.job4all.profile.candidate.model.CreateCandidateResponse;
import com.job4all.profile.candidate.model.UpdateCandidateRequest;
import com.job4all.profile.candidate.model.UpdateCandidateResponse;
import com.job4all.profile.candidate.model.entity.Candidate;
import com.job4all.profile.exception.UserProfileException;

public interface CandidateService {
	public Optional<Candidate> getCandidateById(UUID candidateId) throws UserProfileException;
	public Candidate createCandidate(Candidate candidate) throws UserProfileException;
	public Candidate updateCandidate(UUID candidateId, Candidate candidate)  throws UserProfileException;
	public void deleteCandidateById(UUID candidateId);
}
