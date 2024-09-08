package com.eteration.simplebanking.model;


import lombok.Data;
import lombok.EqualsAndHashCode;


// This class is a place holder you can change the complete implementation
@EqualsAndHashCode(callSuper = true)
@Data
public class DepositTransaction extends Transaction {


    public DepositTransaction(int amount) {
        this.setAmount((double) amount);
    }

    public DepositTransaction(double amount) {
        this.setAmount(amount);
    }

    public DepositTransaction() {
    }
}
