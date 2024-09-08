package com.eteration.simplebanking.services;


import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.entity.AccountEntity;
import com.eteration.simplebanking.enums.TransactionStatusEnum;
import com.eteration.simplebanking.mapper.AccountMapper;
import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

// This class is a place holder you can change the complete implementation
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        Optional<AccountEntity> accountOpt = accountRepository.findByAccountNumber(accountNumber);
        if (accountOpt.isPresent()) {
            return AccountMapper.INSTANCE.toModel(accountOpt.get());
        } else {
            throw new AccountNotFoundException();
        }
    }

    public Account updateAccount(Account account) {
        AccountEntity accountEntity = AccountMapper.INSTANCE.toEntity(account);
        AccountEntity savedEntity = accountRepository.save(accountEntity);
        return accountMapper.toModel(savedEntity);
    }

    @Override
    @Transactional
    public TransactionStatus credit(String accountNumber, DepositTransaction depositTransaction) throws AccountNotFoundException {
        String aprrovalCode = UUID.randomUUID().toString();
        Account account = findAccount(accountNumber);
        account.credit(depositTransaction);
        depositTransaction.setApprovalCode(aprrovalCode);
        updateAccount(account);
        return new TransactionStatus(TransactionStatusEnum.OK, aprrovalCode);
    }

    @Override
    @Transactional
    public TransactionStatus debit(String accountNumber, WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException, AccountNotFoundException {
        String aprrovalCode = UUID.randomUUID().toString();
        Account account = findAccount(accountNumber);
        account.debit(withdrawalTransaction);
        withdrawalTransaction.setApprovalCode(aprrovalCode);
        updateAccount(account);
        return new TransactionStatus(TransactionStatusEnum.OK, aprrovalCode);
    }

}
