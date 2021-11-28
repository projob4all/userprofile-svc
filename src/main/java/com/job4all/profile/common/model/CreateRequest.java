package com.job4all.profile.common.model;

import com.job4all.db.PostgresUtilities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper=false)
public class CreateRequest extends BaseRequest {

	public CreateRequest() {
		super();
		this.setCreated_by(PostgresUtilities.ADMIN_UUID);
		this.setCreated_on(LocalDateTime.now());
	}

	@Override
	public String toString() {
		return "CreateRequest [toString()=" + super.toString() + "]";
	}
	
}
