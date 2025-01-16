package br.com.samuca.fceda.balances.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class BalanceAccount {

    @NonNull
    private String accountId;

    @NonNull
    private Double balance;
}
