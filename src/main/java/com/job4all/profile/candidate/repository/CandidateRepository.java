package com.job4all.profile.candidate.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.job4all.profile.candidate.model.entity.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, UUID>{
	Optional<Candidate> findById(UUID id);
	Candidate findByEmail(String email);
	
	@Query(value = "SELECT c.* FROM candidate c WHERE c.last_name ilike ':last_name%'", nativeQuery = true)
	List<Candidate> findByLastName(@Param("last_name") String lastName);

}
