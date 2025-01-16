package br.com.samuca.fceda.balances.domain.usecase;

import br.com.samuca.fceda.balances.domain.dto.BalanceAccountDto;
import br.com.samuca.fceda.balances.domain.entity.BalanceAccount;
import br.com.samuca.fceda.balances.domain.gateway.BalanceAccountGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindBalanceAccountUseCase {

    private final BalanceAccountGateway balanceAccountGateway;

    public FindBalanceAccountUseCase(BalanceAccountGateway balanceAccountGateway) {
        this.balanceAccountGateway = balanceAccountGateway;
    }

    public Optional<BalanceAccountDto> find(String accountId) {
        Optional<BalanceAccount> balanceAccount = balanceAccountGateway.findByAccountId(accountId);
        if (balanceAccount.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new BalanceAccountDto(balanceAccount.get().getAccountId(),
                balanceAccount.get().getBalance()));
    }
}
