package com.application.carlotaservice.saltedge;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.carlotaservice.saltedge.dto.AttemptDTO;
import com.application.carlotaservice.saltedge.dto.ConnectionDTO;
import com.application.carlotaservice.saltedge.dto.ConsentDTO;
import com.application.carlotaservice.saltedge.dto.CredentialsDTO;
import com.application.carlotaservice.saltedge.dto.DataConnectionDTO;
import com.application.carlotaservice.saltedge.dto.DataConnectionListDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConnectionProxy {
  private static String CONNECTION_URL = "https://www.saltedge.com/api/v5/connections/";
  private RestTemplate restTemplate;
  private HttpHeaders httpHeaders;

  @Autowired
  public ConnectionProxy(RestTemplate restTemplate) {
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

  //TODO complete connection rest end points
  public void showConnections(String connection) {
    setHttpHeaders();
    HttpEntity entity = new HttpEntity(httpHeaders);
    ResponseEntity<DataConnectionDTO> response =
            restTemplate.exchange(CONNECTION_URL + connection, HttpMethod.GET, entity, DataConnectionDTO.class);
    log.info(response.getBody().getData().getId());
//    log.info(response.getBody().getData().getProvider_id());
  }
  
  public void removeConnection(String connection) {
	  setHttpHeaders();
	  HttpEntity entity = new HttpEntity(httpHeaders);
	  ResponseEntity<DataConnectionDTO> response = 
			  restTemplate.exchange(CONNECTION_URL + connection , HttpMethod.DELETE, entity, DataConnectionDTO.class);
//	  log.info("deleted " + response.getBody().getData().isRemoved());
  }
  
  public void showConnectionList(String customerID) {
	  setHttpHeaders();
	  HttpEntity entity = new HttpEntity<>(httpHeaders);
	  ResponseEntity<DataConnectionListDTO> response = 
			  restTemplate.exchange("https://www.saltedge.com/api/v5/connections?customer_id="+ customerID, HttpMethod.GET, entity, DataConnectionListDTO.class);
	  
	   
	  log.info(response.getBody().getMeta().getNext_id() );
	  
	   log.info(  response.getBody().getData().get(0).getId());
  }
  public void createConnection(String customerID, String providerCode, String login, String password) {
  setHttpHeaders();
	  
	  
	//  connectionDTO.setCountry_code("MX");
	//  connectionDTO.setProvider_code(providerCode);
	  
	  
//	  List<String> scopes =  new ArrayList<String>();
//	  scopes.add("account_details");
//	  scopes.add( "transactions_details");
	  ConsentDTO consentDTO = ConsentDTO.builder()
			  .scopes(Arrays.asList("account_details", "transactions_details" ))
			  .build();
	  
	  
//	   List<String> fetch_scopes = new ArrayList<String>();
//	  fetch_scopes.add("accounts");
//	  fetch_scopes.add("transactions");
	  AttemptDTO attemptDTO = AttemptDTO.builder()
			  .fetch_scopes(Arrays.asList("accounts", "transactions" ))
			  .build();
	  
	  CredentialsDTO credentialasDTO = CredentialsDTO.builder()
			  .login(login)
			  .password(password)
			  .build();
	  
	  ConnectionDTO connectionDTO = 
			  ConnectionDTO.builder().customer_id(customerID)
			  .country_code("MX")
			  .provider_code(providerCode)
			  .credentials(credentialasDTO)
			  .consent(consentDTO)
			  .attempt(attemptDTO)
			  .build();
	  
	  
	  DataConnectionDTO dataConnectionDTO = DataConnectionDTO.builder().data(connectionDTO).build();
			  
	  HttpEntity entity = new HttpEntity(dataConnectionDTO, httpHeaders);
	  ResponseEntity<DataConnectionDTO> response =
			  restTemplate.postForEntity(CONNECTION_URL, entity, DataConnectionDTO.class);
	  
	  log.info(response.getBody().getData().getId());
	  
	  
	//  CustomerDTO customerDTO = CustomerDTO.builder().identifier(customer).build();
	//  DataCustomerDTO dataCustomerDTO = DataCustomerDTO.builder().data(customerDTO).build();
	//  HttpEntity entity = new HttpEntity(dataCustomerDTO, httpHeaders);
	//  ResponseEntity<DataCustomerDTO> response =
	//      restTemplate.postForEntity(CUSTOMER_URL, entity, DataCustomerDTO.class);
	//  log.info(response.getBody().getData().getIdentifier());
 }
  
}
