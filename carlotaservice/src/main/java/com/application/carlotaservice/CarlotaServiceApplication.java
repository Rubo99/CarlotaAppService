package com.application.carlotaservice;

import com.application.carlotaservice.saltedge.ConnectionProxy;
import com.application.carlotaservice.saltedge.UserProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarlotaServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarlotaServiceApplication.class, args);
    RestTemplate restTemplate = new RestTemplate();
    org.springframework.http.HttpHeaders headers = new HttpHeaders();
    //UserProxy userProxy = new UserProxy(restTemplate);
    //userProxy.removeCustomer("4522111");
    ConnectionProxy connectionProxy = new ConnectionProxy(restTemplate);
    connectionProxy.showConnections("5499871");
    
  }
}
