package com.eteration.simplebanking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

// This class is a place holder you can change the complete implementation
@EqualsAndHashCode(callSuper = true)
@Data
public class WithdrawalTransaction extends Transaction {


    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    public WithdrawalTransaction(int amount) {
        super((double) amount);
    }

    public WithdrawalTransaction() {
    }
}


