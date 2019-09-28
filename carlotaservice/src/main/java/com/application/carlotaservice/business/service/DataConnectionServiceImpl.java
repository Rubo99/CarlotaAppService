package com.application.carlotaservice.business.service;

import com.application.carlotaservice.saltedge.ConnectionProxy;
import com.application.carlotaservice.saltedge.dto.DataConnectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataConnectionServiceImpl {
  private ConnectionProxy connectionProxy;

  @Autowired
  public DataConnectionServiceImpl(ConnectionProxy connectionProxy) {
    this.connectionProxy = connectionProxy;
  }

  public DataConnectionDTO createConnection(DataConnectionDTO dataConnectionDTO) {
    return connectionProxy.createConnection(
        dataConnectionDTO.getData().getCustomer_id(),
        dataConnectionDTO.getData().getProvider_code(),
        dataConnectionDTO.getData().getCredentials().getLogin(),
        dataConnectionDTO.getData().getCredentials().getPassword());
  }
}
