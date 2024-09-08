package com.eteration.simplebanking.model;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class PhoneBillPaymentTransaction extends BillPaymentTransaction {

    private String company;
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String company, String phoneNumber, double payee) {
        super(payee);
        this.company = company;
        this.phoneNumber = phoneNumber;
    }
}
