package com.eteration.simplebanking.model;


import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// This class is a place holder you can change the complete implementation
@Data
public class Account {

    private Integer id;
    private String owner;
    private String accountNumber;
    private double balance;
    private Date createDate;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(String owner, String accountNumber, double balance, Date createDate, List<Transaction> transactions) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createDate = createDate;
        this.transactions = transactions;
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public void debit(WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        Double amount = withdrawalTransaction.getAmount();
        if (balance < amount) {
            throw new InsufficientBalanceException();
        }
        balance = balance - amount;
        addTransaction(withdrawalTransaction);
    }

    public void credit(DepositTransaction depositTransaction) {
        Double amount = depositTransaction.getAmount();
        balance = balance + amount;
        addTransaction(depositTransaction);
    }

    public void addTransaction(Transaction transaction) {
        transaction.setAccount(this);
        transaction.setDate(new Date());
        if (transactions == null) {
            transactions = new ArrayList<>();
            transactions.add(transaction);
        } else {
            transactions.add(transaction);
        }
    }

    public void post(DepositTransaction depositTransaction) {
        credit(depositTransaction);
    }

    public void post(WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        debit(withdrawalTransaction);
    }

    public void deposit(int i) {
        credit(new DepositTransaction(i));
    }

    public void withdraw(int i) throws InsufficientBalanceException {
        debit(new WithdrawalTransaction(i));
    }

}
