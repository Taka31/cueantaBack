package com.cyrilus.lacuenta.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public @Data
class TransactionDto implements Serializable {

    private String id;
    private String name;
    private LocalDate date;
    private Float amountBuy;
    private Float amountTaxes;
    private Float amountDeduction;
    private Float transfert;
}
