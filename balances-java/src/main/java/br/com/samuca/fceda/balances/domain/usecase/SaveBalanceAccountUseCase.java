package br.com.samuca.fceda.balances.domain.usecase;

import br.com.samuca.fceda.balances.domain.dto.BalanceAccountDto;
import br.com.samuca.fceda.balances.domain.entity.BalanceAccount;
import br.com.samuca.fceda.balances.domain.gateway.BalanceAccountGateway;
import org.springframework.stereotype.Service;

@Service
public class SaveBalanceAccountUseCase {

    private BalanceAccountGateway balanceAccountGateway;

    public SaveBalanceAccountUseCase(BalanceAccountGateway balanceAccountGateway) {
        this.balanceAccountGateway = balanceAccountGateway;
    }

    public void process(BalanceAccountDto balanceAccountDto) {
        BalanceAccount balanceAccount = new BalanceAccount(balanceAccountDto.accountId(), balanceAccountDto.balance());
        balanceAccountGateway.save(balanceAccount);
    }
}
