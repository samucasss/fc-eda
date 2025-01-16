package br.com.samuca.fceda.balances.domain.gateway;

import br.com.samuca.fceda.balances.domain.entity.BalanceAccount;

import java.util.Optional;

public interface BalanceAccountGateway {

    void save(BalanceAccount balance);
    Optional<BalanceAccount> findByAccountId(String accountId);
}
