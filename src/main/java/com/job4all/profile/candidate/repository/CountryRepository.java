package com.job4all.profile.candidate.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.job4all.profile.candidate.model.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String>{
	
	public static final String a="a";
	
	public enum CountryCodes {
	    USA("USA");
		private String countryCode;
	    private CountryCodes(String countryCode) {
	    	this.countryCode=countryCode;
	    }
	    public String code() {
	        return countryCode;
	    }
	}

	Optional<Country> findById(String id);
}
