package com.job4all.profile.candidate.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateRepositoryImpl{

	@Autowired private SessionFactory sessionFactory;

}
