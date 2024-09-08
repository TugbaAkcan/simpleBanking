package com.eteration.simplebanking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

// This class is a place holder you can change the complete implementation

@Getter
@Setter
public abstract class Transaction {

    private Integer id;
    @JsonIgnore
    private Account account;
    private Double amount;
    private Date date;
    private String type;
    private String approvalCode;

    protected Transaction(Double amount) {
        this.date = new Date();
        this.amount = amount;
    }

    protected Transaction() {
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
