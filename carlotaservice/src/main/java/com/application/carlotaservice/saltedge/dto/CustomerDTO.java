package com.application.carlotaservice.saltedge.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
  private String id;
  private String identifier;
  private String secret;
  private boolean deleted;
}
