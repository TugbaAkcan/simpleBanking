package com.eteration.simplebanking.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// This class is a place holder you can change the complete implementation
@Entity
@Table(name = "account")
@Getter
@Setter
public class AccountEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String owner;
    private String accountNumber;
    private double balance;
    private Date createDate;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DepositTransactionEntity> depositTransactions = new ArrayList<>();
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WithdrawalTransactionEntity> withdrawalTransactions = new ArrayList<>();

    public AccountEntity() {
    }

    public AccountEntity(Integer id, String owner, String accountNumber, double balance, Date createDate, List<DepositTransactionEntity> depositTransactions, List<WithdrawalTransactionEntity> withdrawalTransactions) {
        this.id = id;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createDate = createDate;
        this.depositTransactions = depositTransactions;
        this.withdrawalTransactions = withdrawalTransactions;
    }
}
