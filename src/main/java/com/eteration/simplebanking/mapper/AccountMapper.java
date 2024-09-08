package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.entity.AccountEntity;
import com.eteration.simplebanking.entity.DepositTransactionEntity;
import com.eteration.simplebanking.entity.WithdrawalTransactionEntity;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(uses = TransactionMapper.class, componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "accountNumber", source = "accountNumber")
    @Mapping(target = "owner", source = "owner")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "transactions", expression = "java(mergeTransactions(accountEntity))")
    Account toModel(AccountEntity accountEntity);

    @InheritInverseConfiguration
    @Mapping(target = "depositTransactions", expression = "java(getDepositTransactions(account))")
    @Mapping(target = "withdrawalTransactions", expression = "java(getWithdrawalTransactions(account))")
    AccountEntity toEntity(Account account);

    default List<Transaction> mergeTransactions(AccountEntity accountEntity) {
        return Stream.concat(
                accountEntity.getDepositTransactions().stream().map(TransactionMapper.INSTANCE::toDepositTransaction),
                accountEntity.getWithdrawalTransactions().stream().map(TransactionMapper.INSTANCE::toWithdrawalTransaction)
        ).collect(Collectors.toList());
    }

    default List<DepositTransactionEntity> getDepositTransactions(Account account) {
        return account.getTransactions().stream()
                .filter(DepositTransaction.class::isInstance)
                .map(e -> TransactionMapper.INSTANCE.toDepositTransactionEntity((DepositTransaction) e))
                .collect(Collectors.toList());
    }

    default List<WithdrawalTransactionEntity> getWithdrawalTransactions(Account account) {
        return account.getTransactions().stream()
                .filter(WithdrawalTransaction.class::isInstance)
                .map(e -> TransactionMapper.INSTANCE.toWithdrawalTransactionEntity((WithdrawalTransaction) e))
                .collect(Collectors.toList());
    }

}
