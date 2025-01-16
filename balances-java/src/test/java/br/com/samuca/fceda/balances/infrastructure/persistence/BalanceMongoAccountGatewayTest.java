package br.com.samuca.fceda.balances.infrastructure.persistence;

import br.com.samuca.fceda.balances.domain.entity.BalanceAccount;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BalanceMongoAccountGatewayTest {

    @Test
    void save() {
        BalanceMongoRepository balanceMongoRepository = Mockito.mock(BalanceMongoRepository.class);
        Mockito.when(balanceMongoRepository.save(Mockito.any())).thenReturn(null);

        BalanceMongoAccountGateway balanceMongoAccountGateway = new BalanceMongoAccountGateway(balanceMongoRepository);

        BalanceAccount balanceAccount = new BalanceAccount("1", 100.0);
        balanceMongoAccountGateway.save(balanceAccount);

        Mockito.verify(balanceMongoRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void findByAccountId() {
        BalanceDocument balanceDocument = new BalanceDocument("1", 100.0);
        BalanceMongoRepository balanceMongoRepository = Mockito.mock(BalanceMongoRepository.class);
        Mockito.when(balanceMongoRepository.findByAccountId("1")).thenReturn(balanceDocument);

        BalanceMongoAccountGateway balanceMongoAccountGateway = new BalanceMongoAccountGateway(balanceMongoRepository);

        BalanceAccount balanceAccount = balanceMongoAccountGateway.findByAccountId("1").orElse(null);

        Mockito.verify(balanceMongoRepository, Mockito.times(1)).findByAccountId("1");
        assertEquals("1", balanceAccount.getAccountId());
        assertEquals(100.0, balanceAccount.getBalance());
    }
}