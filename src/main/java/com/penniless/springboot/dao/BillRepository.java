package com.penniless.springboot.dao;

import com.penniless.springboot.model.Bill;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BillRepository extends MongoRepository<Bill, ObjectId> {
  Optional<Bill> findByExternalId(String externalId);
}
