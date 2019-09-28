package com.application.carlotaservice.web;

import com.application.carlotaservice.business.service.DataConnectionServiceImpl;
import com.application.carlotaservice.business.service.UserServiceImpl;
import com.application.carlotaservice.saltedge.dto.DataConnectionDTO;
import com.application.carlotaservice.saltedge.dto.DataCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarlotaAppController {

  private UserServiceImpl userService;
  private DataConnectionServiceImpl dataConnectionService;

  @Autowired
  public CarlotaAppController(
      UserServiceImpl userService, DataConnectionServiceImpl dataConnectionService) {
    this.userService = userService;
    this.dataConnectionService = dataConnectionService;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/createUser")
  private String createUser(@RequestBody DataCustomerDTO customer) {
    return userService.createUser(customer);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/showCustomer")
  private DataCustomerDTO showCustomer(@RequestBody DataCustomerDTO customer) {
    return userService.getCustomer(customer);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/createConnection")
  private DataConnectionDTO createConnection(@RequestBody DataConnectionDTO dataConnectionDTO) {
    return dataConnectionService.createConnection(dataConnectionDTO);
  }
}
