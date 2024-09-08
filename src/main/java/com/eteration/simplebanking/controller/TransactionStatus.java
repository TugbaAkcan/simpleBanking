package com.eteration.simplebanking.controller;


import com.eteration.simplebanking.enums.TransactionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This class is a place holder you can change the complete implementation
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionStatus {

    private TransactionStatusEnum status;

    private String approvalCode;

    public TransactionStatus(TransactionStatusEnum transactionStatusEnum) {
        this.status = transactionStatusEnum;
    }

}
