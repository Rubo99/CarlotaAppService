package com.application.carlotaservice;

import com.application.carlotaservice.saltedge.UserProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarlotaServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarlotaServiceApplication.class, args);
    UserProxy userProxy = new UserProxy();
    userProxy.getCustomer();
  }
}
