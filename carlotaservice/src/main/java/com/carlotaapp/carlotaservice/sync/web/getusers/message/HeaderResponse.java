package com.carlotaapp.carlotaservice.sync.web.getusers.message;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HeaderResponse {
    String rid;
    String code;
    String errors;
    String message;
    List<GetUser> response;
}
