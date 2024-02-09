package com.cyrilus.lacuenta.repository;

import com.cyrilus.lacuenta.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction,String>{
}
