package com.carlotaapp.carlotaservice.sync.web.getusers;

import com.carlotaapp.carlotaservice.sync.web.getusers.message.GetUser;
import com.carlotaapp.carlotaservice.sync.web.getusers.message.HeaderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class UsersService {
  public static void getSyncUsers() {
    RestTemplate restTemplate = new RestTemplate();
    HeaderResponse headerResponse =
        restTemplate.getForObject(
            "https://sync.paybook.com/v1/users?api_key=e2b33653839a5bf37f726f573d5ab5a3",
            HeaderResponse.class);
    for (GetUser getUser : headerResponse.getResponse()) {
      log.info(getUser.getName());
    }
  }

  public static void createSyncUsers() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    String data =
        "{\n"
            + "    \"api_key\" : \"e2b33653839a5bf37f726f573d5ab5a3\",\n"
            + "    \"name\" : \"Luis Armando Mercado\"\n"
            + "}";
    HttpEntity<String> request = new HttpEntity<>(data, headers);
    String result =
        restTemplate
            .postForEntity(
                "https://sync.paybook.com/v1/users?api_key=e2b33653839a5bf37f726f573d5ab5a3",
                request,
                String.class)
            .getBody();
    log.info(result);
  }
}
