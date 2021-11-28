package com.job4all.profile.common.model;

import java.time.LocalDateTime;

import com.job4all.db.PostgresUtilities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UpdateRequest extends BaseRequest {
	
	public UpdateRequest() {
		super();
		this.setUpdated_by(PostgresUtilities.ADMIN_UUID);
		this.setUpdated_on(LocalDateTime.now());
	}

	@Override
	public String toString() {
		return "UpdateRequest [toString()=" + super.toString() + "]";
	}
	
}
