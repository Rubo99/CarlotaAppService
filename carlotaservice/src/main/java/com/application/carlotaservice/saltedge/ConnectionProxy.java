package com.application.carlotaservice.saltedge;

import com.application.carlotaservice.saltedge.dto.DataCustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ConnectionProxy {
  private static String CUSTOMER_URL = "https://www.saltedge.com/api/v5/connections/";
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
  public void showConnections(String customer) {
    setHttpHeaders();
    HttpEntity entity = new HttpEntity(httpHeaders);
    ResponseEntity<DataCustomerDTO> response =
            restTemplate.exchange(CUSTOMER_URL + customer, HttpMethod.GET, entity, DataCustomerDTO.class);
    log.info(response.getBody().getData().getId());
  }
}
