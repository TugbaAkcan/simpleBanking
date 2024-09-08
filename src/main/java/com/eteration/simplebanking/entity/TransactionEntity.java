package com.eteration.simplebanking.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

// This class is a place holder you can change the complete implementation
@Getter
@Setter
@MappedSuperclass
public abstract class TransactionEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private Double amount;
    private Date date;
    private String approvalCode;
    @Transient
    private String type;

}
