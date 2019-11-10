package com.penniless.springboot.controller.v1;

import com.penniless.springboot.model.dto.BillDto;
import com.penniless.springboot.model.request.CreateBillRequest;
import com.penniless.springboot.service.BillingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillingController {

  private BillingService billingService;

  public BillingController(BillingService billingService) {
    this.billingService = billingService;
  }

  @GetMapping("/{ext_id}")
  public ResponseEntity getBill(@PathVariable("ext_id") String id) {
    return ResponseEntity.ok(billingService.findBillById(id));
  }

  @PostMapping("/create")
  public ResponseEntity createBill(@RequestBody CreateBillRequest createBillRequest) {
    BillDto billDto = new BillDto()
        .setName(createBillRequest.getName())
        .setDescription(createBillRequest.getDescription())
        .setPaidBy(createBillRequest.getPaidBy())
        .setPayersExtIds(createBillRequest.getPayersExtIds())
        .setTotalAmount(createBillRequest.getTotalAmount());

    return ResponseEntity.status(HttpStatus.CREATED).body(billingService.createNewBill(billDto));
  }
}
