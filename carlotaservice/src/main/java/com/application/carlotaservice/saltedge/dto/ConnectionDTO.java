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
public class ConnectionDTO {
	  private String id;
	  private String secret;
	  private String provider_id;
	  private String provider_code;
	  private String provider_name;
	  private String customer_id;
	  private String next_refresh_possible_at;
	  private String created_at;
	  private String updated_at;
	  private String status;
	  private String categorization;
	  private String daily_refresh;
	  private String store_credentials;
	  private String country_code;
	  private String last_success_at;
	  private String show_consent_confirmation;
	  private String last_consent_id;
}

/*
"id": "5499871",
"secret": "AIw1wZ0dm00BmQkSH21O-44lPqYfaSEj-grSGwV7c0c",
"provider_id": "2917",
"provider_code": "banamex_bancanet_mx",
"provider_name": "Banamex (Citi BancaNet)",
"customer_id": "4516126",
"next_refresh_possible_at": null,
"created_at": "2019-08-01T19:54:51Z",
"updated_at": "2019-08-01T19:56:24Z",
"status": "active",
"categorization": "personal",
"daily_refresh": false,
"store_credentials": false,
"country_code": "MX",
"last_success_at": "2019-08-01T19:56:24Z",
"show_consent_confirmation": true,
"last_consent_id": "3639199",

*/