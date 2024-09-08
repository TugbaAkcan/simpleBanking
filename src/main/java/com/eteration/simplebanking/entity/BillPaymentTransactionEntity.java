package com.eteration.simplebanking.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BillPaymentTransactionEntity extends WithdrawalTransactionEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String payee;
}
