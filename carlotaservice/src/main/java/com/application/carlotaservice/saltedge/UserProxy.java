package com.application.carlotaservice.saltedge;

import com.application.carlotaservice.saltedge.dto.CustomerDTO;
import com.application.carlotaservice.saltedge.dto.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class UserProxy {
  private static String CUSTOMER_URL = "https://www.saltedge.com/api/v5/customers/";
  private RestTemplate restTemplate;
  private HttpHeaders httpHeaders;

  @Autowired
  public UserProxy(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void getCustomer(String customer) {
    setHttpHeaders();
    HttpEntity entity = new HttpEntity(httpHeaders);
    ResponseEntity<DataDTO> response =
        restTemplate.exchange(CUSTOMER_URL + customer, HttpMethod.GET, entity, DataDTO.class);
    log.info(response.getBody().getData().getId());
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

  public void createCustomer(String customer) {
    setHttpHeaders();
    CustomerDTO customerDTO = CustomerDTO.builder().identifier(customer).build();
    DataDTO dataDTO = DataDTO.builder().data(customerDTO).build();
    HttpEntity entity = new HttpEntity(dataDTO, httpHeaders);
    ResponseEntity<DataDTO> response =
        restTemplate.postForEntity(CUSTOMER_URL, entity, DataDTO.class);
    log.info(response.getBody().getData().getIdentifier());
  }

  public void removeCustomer(String customer) {
    setHttpHeaders();
    HttpEntity entity = new HttpEntity(httpHeaders);
    ResponseEntity<DataDTO> response =
        restTemplate.exchange(CUSTOMER_URL + customer, HttpMethod.DELETE, entity, DataDTO.class);
    log.info("deleted" + response.getBody().getData().isDeleted());
  }
}
