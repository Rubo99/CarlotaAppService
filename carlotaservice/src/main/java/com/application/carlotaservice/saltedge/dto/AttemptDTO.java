package com.application.carlotaservice.saltedge.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttemptDTO {
	
	@Singular
	private List<String> fetch_scopes;
	

}
