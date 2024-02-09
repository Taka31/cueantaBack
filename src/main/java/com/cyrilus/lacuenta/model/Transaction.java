package com.cyrilus.lacuenta.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class Transaction implements Serializable {

    @Id
    private String id;
    private String name;
    private LocalDate date;
    private Float amountBuy;
    private Float amountTaxes;
    private Float amountDeduction;
    private Float transfert;

}
