package com.penniless.springboot.service;

import com.penniless.springboot.Util.Util;
import com.penniless.springboot.dao.BillRepository;
import com.penniless.springboot.model.Bill;
import com.penniless.springboot.model.PayerStatus;
import com.penniless.springboot.model.dto.BillDto;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

  private BillRepository billRepository;

  public BillingServiceImpl(BillRepository billRepository) {
    this.billRepository = billRepository;
  }

  public Bill findBillById(String id) {
    Optional<Bill> persistentBill = billRepository.findByExternalId(id);
    if (!persistentBill.isPresent()) {
      return null;
    }

    return persistentBill.get();
  }

  public Bill createNewBill(BillDto billDto) {
    String extID = Util.genExternalId();
    double amtPerPax = calculateAmountPerPax(billDto.getPayersExtIds().size(), billDto.getTotalAmount());

    Bill newBill =
        new Bill()
            .setExternalId(extID)
            .setName(billDto.getName())
            .setDescription(billDto.getDescription())
            .setPaidBy(billDto.getPaidBy())
            .setTotalAmount(billDto.getTotalAmount())
            .setBillResolved(false)
            .setPayerStatuses(
                billDto.getPayersExtIds().stream()
                    .map(
                        externalId -> {
                          return new PayerStatus()
                              .setUserExternalId(externalId)
                              .setOwes(amtPerPax)
                              .setAmountPaid(0.0);
                        })
                    .collect(Collectors.toList()));

    long now = Instant.now().toEpochMilli();
    newBill.setDateCreated(now);
    return billRepository.save(newBill);
  }

  private double calculateAmountPerPax(int numberOfPayers, double cost) {
    return cost / (numberOfPayers + 1);
  }
}
