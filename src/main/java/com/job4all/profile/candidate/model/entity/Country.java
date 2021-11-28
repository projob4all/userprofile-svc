package com.job4all.profile.candidate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name="country")
public class Country {
	
	@Id
	@Column(name="country_code", updatable = false, unique=true)
	private String countryCode;

	@NonNull
	private String description;

	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", description=" + description + "]";
	}
	
	/*@OneToMany(mappedBy="country", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Candidate.class)
    private List<Candidate> candidates;*/
	
	

}
