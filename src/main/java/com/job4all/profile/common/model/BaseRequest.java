package com.job4all.profile.common.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job4all.db.PostgresUtilities;
import lombok.Data;


@Data
public class BaseRequest {
	
	@JsonIgnore
	private LocalDateTime created_on;
	@JsonIgnore
	private UUID created_by;
	@JsonIgnore
	private LocalDateTime updated_on;
	@JsonIgnore
	private UUID updated_by;
	
}
