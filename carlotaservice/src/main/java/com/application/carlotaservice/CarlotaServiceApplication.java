package com.application.carlotaservice;

import com.application.carlotaservice.saltedge.AccountsProxy;
import com.application.carlotaservice.saltedge.ConnectionProxy;
import com.application.carlotaservice.saltedge.TransactionsProxy;
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
    //userProxy.createCustomer("david@test.123");
    //userProxy.removeCustomer("4522111");
    ConnectionProxy connectionProxy = new ConnectionProxy(restTemplate);
    //connectionProxy.showConnections("5499871");
    // connectionProxy.showConnectionList("6863151");
    //connectionProxy.removeConnection("6813171");
    //connectionProxy.createConnection("6863151", "banamex_bancanet_mx", "USERNAME", "PASSWORD");
    
   AccountsProxy accountsProxy =  new AccountsProxy(restTemplate);
   
   accountsProxy.getAccounts("6813179");
   
   
   TransactionsProxy transactionsProxy = new TransactionsProxy(restTemplate);
   
   transactionsProxy.getTransactions("6813179", "9260152");
    
  }
}
