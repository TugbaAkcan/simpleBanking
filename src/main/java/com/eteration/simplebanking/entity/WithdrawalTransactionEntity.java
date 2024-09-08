package com.eteration.simplebanking.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// This class is a place holder you can change the complete implementation
@Entity
@Table(name = "withdrawalTransaction")
@Getter
@Setter
public class WithdrawalTransactionEntity extends TransactionEntity {

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private AccountEntity account;

    public WithdrawalTransactionEntity(int amount) {
        this.setAmount((double) amount);
    }

    public WithdrawalTransactionEntity(double amount) {
        this.setAmount(amount);
    }

    public WithdrawalTransactionEntity() {
    }
}


