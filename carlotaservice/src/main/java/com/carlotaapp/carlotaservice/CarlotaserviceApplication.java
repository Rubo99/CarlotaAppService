package com.carlotaapp.carlotaservice;

import com.carlotaapp.carlotaservice.sync.web.getusers.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CarlotaserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarlotaserviceApplication.class, args);
    UsersService.createSyncUsers();
    UsersService.getSyncUsers();
  }
}
