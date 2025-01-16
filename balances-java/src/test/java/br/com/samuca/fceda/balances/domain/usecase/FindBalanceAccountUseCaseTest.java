package br.com.samuca.fceda.balances.domain.usecase;

import br.com.samuca.fceda.balances.domain.dto.BalanceAccountDto;
import br.com.samuca.fceda.balances.domain.entity.BalanceAccount;
import br.com.samuca.fceda.balances.domain.gateway.BalanceAccountGateway;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindBalanceAccountUseCaseTest {

    @Test
    void find() {
        BalanceAccount balanceAccount = new BalanceAccount("123", 100.0);
        BalanceAccountGateway balanceAccountGateway = Mockito.mock(BalanceAccountGateway.class);
        Mockito.when(balanceAccountGateway.findByAccountId("123")).thenReturn(Optional.of(balanceAccount));

        FindBalanceAccountUseCase findBalanceAccountUseCase = new FindBalanceAccountUseCase(balanceAccountGateway);
        BalanceAccountDto balanceAccountDto = findBalanceAccountUseCase.find("123").orElse(null);

        Mockito.verify(balanceAccountGateway).findByAccountId("123");

        assertEquals("123", balanceAccountDto.accountId());
        assertEquals(100.0, balanceAccountDto.balance());
    }
}