package com.carlotaapp.carlotaservice.sync.web.getusers.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUser {
    String id_user;
    String id_external;
    String name;
    String dt_create;
    String dt_modify;
}
