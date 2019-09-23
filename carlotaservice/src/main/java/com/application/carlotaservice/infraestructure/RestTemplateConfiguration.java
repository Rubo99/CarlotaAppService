package com.application.carlotaservice.infraestructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public HttpHeaders httpHeaders() {
    HttpHeaders httpHeaders = new HttpHeaders();
    String MEDIA_TYPE = "application/json";
    httpHeaders.set("Accept", MEDIA_TYPE);
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    String API_ID = "aNwAT0TY91LzWVKmgNH58a5aMK_fJtppR4R0uMkftkA";
    httpHeaders.set("App-id", API_ID);
    String SECRET = "SGQS_Gi2shsHQpvbCVoLQzBC6VeSDWv2xb_nJpMp4jc";
    httpHeaders.set("Secret", SECRET);
    return httpHeaders;
  }
}
