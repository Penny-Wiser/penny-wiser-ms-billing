package com.penniless.springboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PayerStatus {
  private String userExternalId;
  private double owes;
  private double amountPaid;
  private long datePaid;

  public boolean hasPaid() {
    return amountPaid == owes;
  }
}
