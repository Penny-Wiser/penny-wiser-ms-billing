package com.penniless.springboot.service;

import com.penniless.springboot.model.Bill;
import com.penniless.springboot.model.dto.BillDto;

public interface BillingService {
  Bill findBillById(String id);
  Bill createNewBill(BillDto billDto);
}
