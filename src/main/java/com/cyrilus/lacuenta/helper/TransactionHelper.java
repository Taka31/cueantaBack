package com.cyrilus.lacuenta.helper;

import com.cyrilus.lacuenta.dto.TransactionDto;
import com.cyrilus.lacuenta.model.Transaction;
import org.springframework.beans.BeanUtils;

public class TransactionHelper {

    public static Transaction transactionDtoToEntity(TransactionDto transactionDto){
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDto,transaction);
        return transaction;
    }
}
