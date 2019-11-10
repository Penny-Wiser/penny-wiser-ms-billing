package com.penniless.springboot.model;

import com.penniless.springboot.Util.Util;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Document(collection = "bills")
public class Bill {
  private String externalId;
  private long dateCreated;
  private String name;
  private String description;
  private String paidBy;
  private double totalAmount;
  private List<PayerStatus> payerStatuses;
  private boolean isBillResolved;
}
