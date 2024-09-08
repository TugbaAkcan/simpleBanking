package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@RestController
@RequestMapping(path = "/account/v1")
public class AccountController {

    private IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountNumber") String accountNumber) throws AccountNotFoundException {
        return new ResponseEntity<>(accountService.findAccount(accountNumber), HttpStatus.OK);
    }

    @PostMapping(value = "/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable("accountNumber") String accountNumber, @RequestBody DepositTransaction depositTransaction) throws AccountNotFoundException {
        TransactionStatus transactionStatus = accountService.credit(accountNumber, depositTransaction);
        return new ResponseEntity<>(transactionStatus, HttpStatus.OK);
    }

    @PostMapping(value = "/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountNumber, @RequestBody WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException, AccountNotFoundException {
        TransactionStatus transactionStatus = accountService.debit(accountNumber, withdrawalTransaction);
        return new ResponseEntity<>(transactionStatus, HttpStatus.OK);
    }
}