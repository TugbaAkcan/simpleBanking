package com.eteration.simplebanking.model;

import lombok.*;

@Getter
@Setter
public class BillPaymentTransaction extends WithdrawalTransaction {

    private Integer id;
    private double payee;

    public BillPaymentTransaction(double payee) {
        super(payee);
        this.payee = payee;
    }

    @Override
    public String toString() {
        return "BillPaymentTransaction{" +
                "id=" + id +
                ", payee=" + payee +
                '}';
    }
}
