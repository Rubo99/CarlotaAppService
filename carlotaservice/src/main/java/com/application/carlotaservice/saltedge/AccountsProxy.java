package com.application.carlotaservice.saltedge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.application.carlotaservice.saltedge.dto.DataAccountListDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountsProxy {

	private static String ACCOUNTS_URL = "https://www.saltedge.com/api/v5/accounts?connection_id=";
	  private RestTemplate restTemplate;
	  private HttpHeaders httpHeaders;

	  @Autowired
	  public AccountsProxy(RestTemplate restTemplate) {
	    this.restTemplate = restTemplate;
	  }
	  
	  private void setHttpHeaders() {
		    String MEDIA_TYPE = "application/json";
		    String API_ID = "aNwAT0TY91LzWVKmgNH58a5aMK_fJtppR4R0uMkftkA";
		    String SECRET = "SGQS_Gi2shsHQpvbCVoLQzBC6VeSDWv2xb_nJpMp4jc";
		    httpHeaders = new HttpHeaders();
		    httpHeaders.set("Accept", MEDIA_TYPE);
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		    httpHeaders.set("App-id", API_ID);
		    httpHeaders.set("Secret", SECRET);
		  }
	  
	  public void getAccounts(String connectionID) {
		    setHttpHeaders();
		    HttpEntity entity = new HttpEntity(httpHeaders);
		    ResponseEntity<DataAccountListDTO> response =
		    		restTemplate.exchange(ACCOUNTS_URL + connectionID, HttpMethod.GET, entity, DataAccountListDTO.class);
		    log.info(response.getBody().getData().get(0).getName()); 
		  }

}
