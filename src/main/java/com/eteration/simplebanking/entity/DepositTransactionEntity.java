package com.eteration.simplebanking.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// This class is a place holder you can change the complete implementation
@Entity
@Table(name = "depositTransaction")
@Getter
@Setter
public class DepositTransactionEntity extends TransactionEntity {

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private AccountEntity account;

    public DepositTransactionEntity(int amount) {
        this.setAmount((double) amount);
    }

    public DepositTransactionEntity(double amount) {
        this.setAmount(amount);
    }

    public DepositTransactionEntity() {
    }
}
