package com.application.carlotaservice.saltedge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.application.carlotaservice.saltedge.dto.DataTransactionsDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TransactionsProxy {

	private static String TRANSACTIONS_URL = "https://www.saltedge.com/api/v5/transactions?connection_id=";
	//"https://www.saltedge.com/api/v5/transactions?connection_id=6813179&account_id=9260152"
	  private RestTemplate restTemplate;
	  private HttpHeaders httpHeaders;

	  @Autowired
	  public TransactionsProxy(RestTemplate restTemplate) {
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
	  
	  public void getTransactions(String connectionID, String accountID) {
		  setHttpHeaders();
		  HttpEntity entity = new HttpEntity(httpHeaders);
		  ResponseEntity<DataTransactionsDTO> response =
				  restTemplate.exchange(TRANSACTIONS_URL + connectionID + "&account_id=" + accountID, HttpMethod.GET,entity,DataTransactionsDTO.class);
		  
		  log.info(response.getBody().getData().get(0).getDescription());
   
	  }
}
