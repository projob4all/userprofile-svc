package com.job4all.profile.candidate.model.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="candidate")
public class Candidate extends BaseEntity{
	
	@Id
	//@NonNull
	//@GeneratedValue( generator = "entityIdGenerator" )
	//@GenericGenerator( name = "entityIdGenerator", strategy = "uuid2" )
	@GeneratedValue
	@Column(name="candidate_id", columnDefinition = "uuid", updatable = false )
	private UUID candidateId;

	@NonNull
	private String email;
	
	@NonNull
	@Column(name="first_name")
	private String firstName;
	
	@NonNull
	@Column(name="last_name")
	private String lastName;
	
	@NonNull
	private String phone;
	
	@NonNull
	private String address1;

	private String address2;
	private String address3;
	private String address4;

	private String unit;

	@NonNull
	private String city;

	@NonNull
	@Column(name="postal_code")
	private String postalCode;

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name="country_code")
    private Country country;

	@NonNull
	private Boolean active;

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + ", address1=" + address1 + ", address2=" + address2 + ", address3="
				+ address3 + ", address4=" + address4 + ", unit=" + unit + ", city=" + city + ", postalCode="
				+ postalCode + ", country=" + country + ", active=" + active + "]";
	}
	
	

}
