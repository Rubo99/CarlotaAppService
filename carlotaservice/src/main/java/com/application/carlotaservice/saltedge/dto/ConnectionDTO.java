package com.application.carlotaservice.saltedge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonIgnoreProperties(value={ "status"  }, allowSetters= true)
public class ConnectionDTO {
 	  private String id;
 	   
 	  @JsonProperty("secret")
	  private String secret;
 	  @JsonProperty("provider_id")
	  private String provider_id;
	  
	  private String provider_code;
	  @JsonProperty("provider_name")
	  private String provider_name;
	   
	  private String customer_id;
	  @JsonProperty("next_refresh_possible_at")
	  private String next_refresh_possible_at;
	  @JsonProperty("created_at")
	  private String created_at;
	  @JsonProperty("updated_at")
	  private String updated_at;
	  @JsonProperty("status")
	  private String status;
	  @JsonProperty("categorization")
	  private String categorization;
	  @JsonProperty("daily_refresh")
	  private String daily_refresh;
	  @JsonProperty("store_credentials")
	  private String store_credentials;
	  
	  private String country_code;
	  @JsonProperty("last_success_at")
	  private String last_success_at;
	  @JsonProperty("show_consent_confirmation")
	  private String show_consent_confirmation;
	  @JsonProperty("last_consent_id")
	  private String last_consent_id;
	  
	  
	  private boolean removed;
	  private CredentialsDTO credentials;
	  private AttemptDTO attempt;
	  private ConsentDTO consent;
}

