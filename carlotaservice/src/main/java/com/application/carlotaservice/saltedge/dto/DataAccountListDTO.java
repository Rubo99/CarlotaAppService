package com.application.carlotaservice.saltedge.dto;

import java.util.ArrayList;

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
public class DataAccountListDTO {

	private ArrayList<AccountDTO> data;
	private MetaDTO meta;
	
	
}
