package com.application.carlotaservice.saltedge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

	private String id;
	private String connection_id;
	private String name;
	private Integer balance;
	private String currency_code;
	private ExtraAccountDTO extra;
	private String created_at;
	private String updated_at;
	
}
