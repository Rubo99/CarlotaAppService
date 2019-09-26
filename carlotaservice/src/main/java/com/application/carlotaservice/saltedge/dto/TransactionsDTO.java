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
public class TransactionsDTO {
	
	private String id;
	private String account_id;
	private Boolean duplicated;
	private String mode;
	private String status;
	private String made_on;
	private Double amount;
	private String currency_code;
	private String description;
	private String category;
	private ExtraTransactionsDTO extra;
	private String created_at;
	private String updated_at;
	
}

