package com.cyrilus.lacuenta.service;

import com.cyrilus.lacuenta.controller.TransactionController;
import com.cyrilus.lacuenta.dto.TransactionDto;
import com.cyrilus.lacuenta.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<Transaction> saveTransaction(TransactionDto transactionDto);

    Mono<Transaction> findById(String id);

    Flux<Transaction> findAll();

    Mono<Transaction> update(TransactionDto transactionDto);

    Mono<Void> delete(String id);
}
