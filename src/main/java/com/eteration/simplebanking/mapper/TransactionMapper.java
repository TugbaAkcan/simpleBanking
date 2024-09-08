package com.eteration.simplebanking.mapper;

import com.eteration.simplebanking.entity.DepositTransactionEntity;
import com.eteration.simplebanking.entity.WithdrawalTransactionEntity;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AccountMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "account.transactions", ignore = true)
    @Mapping(target = "type", defaultValue = "DepositTransaction")
    DepositTransaction toDepositTransaction(DepositTransactionEntity depositTransactionEntity);

    @Mapping(target = "account.depositTransactions", ignore = true)
    @Mapping(target = "account.withdrawalTransactions", ignore = true)
    DepositTransactionEntity toDepositTransactionEntity(DepositTransaction depositTransaction);

    @Mapping(target = "account.transactions", ignore = true)
    @Mapping(target = "type", defaultValue = "WithdrawalTransaction")
    WithdrawalTransaction toWithdrawalTransaction(WithdrawalTransactionEntity withdrawalTransactionEntity);

    @Mapping(target = "account.withdrawalTransactions", ignore = true)
    @Mapping(target = "account.depositTransactions", ignore = true)
    WithdrawalTransactionEntity toWithdrawalTransactionEntity(WithdrawalTransaction withdrawalTransaction);


}
