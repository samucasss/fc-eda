package br.com.samuca.fceda.balances.domain.usecase;

import br.com.samuca.fceda.balances.domain.dto.BalanceAccountDto;
import br.com.samuca.fceda.balances.domain.gateway.BalanceAccountGateway;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SaveBalanceAccountUseCaseTest {

    @Test
    void process() {
        BalanceAccountGateway balanceAccountGateway = Mockito.mock(BalanceAccountGateway.class);
        Mockito.doNothing().when(balanceAccountGateway).save(Mockito.any());

        SaveBalanceAccountUseCase saveBalanceAccountUseCase = new SaveBalanceAccountUseCase(balanceAccountGateway);
        saveBalanceAccountUseCase.process(new BalanceAccountDto("123", 100.0));

        Mockito.verify(balanceAccountGateway, Mockito.times(1)).save(Mockito.any());
    }
}