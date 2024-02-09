package com.cyrilus.lacuenta.controller;

import com.cyrilus.lacuenta.dto.TransactionDto;
import com.cyrilus.lacuenta.model.Transaction;
import com.cyrilus.lacuenta.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/api/transaction")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    public ResponseEntity<Mono<Transaction>> save(@RequestBody TransactionDto transactionDto) throws ExecutionException, InterruptedException {
        Mono<Transaction> result = service.saveTransaction(transactionDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Transaction>> findById(@PathVariable String id) {
        Mono<Transaction> result = service.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Flux<Transaction>> findAll() {
        Flux<Transaction> result = service.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<Transaction>> update(@RequestBody TransactionDto transactionDto, String id) {
        Mono<Transaction> result = service.update(transactionDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id).subscribe();
    }


}
