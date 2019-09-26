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
public class ExtraAccountDTO {
	private String account_number;
	private Double available_amount;
	private Double credit_limit;
	private String next_payment_date;
	private String statement_cut_date;
	private TransactionsCountAccountDTO transactions_count;
	private String last_posted_transaction_id;
	private Double next_payment_amount;
	
	
 
}

 