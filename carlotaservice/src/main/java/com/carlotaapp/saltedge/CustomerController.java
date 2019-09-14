package com.carlotaapp.saltedge;

import com.carlotaapp.saltedge.dto.DataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CustomerController {

  public void getCustomer() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("App-id", "aNwAT0TY91LzWVKmgNH58a5aMK_fJtppR4R0uMkftkA");
    headers.set("Secret", "SGQS_Gi2shsHQpvbCVoLQzBC6VeSDWv2xb_nJpMp4jc");
    HttpEntity entity = new HttpEntity(headers);

    ResponseEntity<DataDTO> response =
        restTemplate.exchange(
            "https://www.saltedge.com/api/v5/customers/4516126",
            HttpMethod.GET,
            entity,
            DataDTO.class);
    log.info(response.getBody().getData().getId());
  }
}
