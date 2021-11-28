package com.job4all.profile.candidate.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
	
	@Column(name="created_on")
	private LocalDateTime created_on;

	@Column(name="created_by", columnDefinition = "uuid")
	private UUID created_by;

	@Column(name="updated_on")
	private LocalDateTime updated_on;

	@Column(name="updated_by", columnDefinition = "uuid")
	private UUID updated_by;

}
