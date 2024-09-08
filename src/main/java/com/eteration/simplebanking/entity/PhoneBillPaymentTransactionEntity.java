package com.eteration.simplebanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBillPaymentTransactionEntity extends BillPaymentTransactionEntity {

    private String phoneNumber;
}
