package com.cyrilus.lacuenta.service;

import com.cyrilus.lacuenta.dto.TransactionDto;
import com.cyrilus.lacuenta.helper.TransactionHelper;
import com.cyrilus.lacuenta.model.Transaction;
import com.cyrilus.lacuenta.repository.TransactionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @NonNull
    private TransactionRepository repo;


    @Override
    public Mono<Transaction> saveTransaction(TransactionDto transactionDto) {
        if (Objects.nonNull(transactionDto)) {
            return repo.save(TransactionHelper.transactionDtoToEntity(transactionDto));
        } else {
            return null;
        }
    }

    @Override
    public Mono<Transaction> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Flux<Transaction> findAll() {
        return repo.findAll();
    }

    @Override
    public Mono<Transaction> update(TransactionDto transactionDto) {
        return this.repo.findById(transactionDto.getId())
                .map(transaction -> TransactionHelper.transactionDtoToEntity(transactionDto))
                .flatMap(this.repo::save);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repo.deleteById(id);
    }
}
