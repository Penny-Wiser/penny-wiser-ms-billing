package com.penniless.springboot.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class BillDto {
  private String name;
  private String description;
  private String paidBy;
  private List<String> payersExtIds;
  private double totalAmount;
}
