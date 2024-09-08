package com.eteration.simplebanking.services;

import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.*;

public interface IAccountService {

    public Account findAccount(String accountNumber) throws AccountNotFoundException;

    public Account updateAccount(Account account);

    public TransactionStatus credit(String accountNumber, DepositTransaction depositTransaction) throws AccountNotFoundException;

    public TransactionStatus debit(String accountNumber, WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException, AccountNotFoundException;
}
