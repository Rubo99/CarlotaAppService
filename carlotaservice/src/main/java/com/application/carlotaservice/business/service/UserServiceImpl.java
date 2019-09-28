package com.application.carlotaservice.business.service;

import com.application.carlotaservice.saltedge.UserProxy;
import com.application.carlotaservice.saltedge.dto.DataCustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl {
  private UserProxy userProxy;

  @Autowired
  public UserServiceImpl(UserProxy userProxy) {
    this.userProxy = userProxy;
  }

  public String createUser(DataCustomerDTO customer) {
    try {
      userProxy.createCustomer(customer.getData().getIdentifier());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "Request created, for user " + customer.getData().getIdentifier();
  }

  public DataCustomerDTO getCustomer(DataCustomerDTO customer) {
    return userProxy.getCustomer(customer.getData().getIdentifier());
  }
}
