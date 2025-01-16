package br.com.samuca.fceda.balances.infrastructure.persistence;

import br.com.samuca.fceda.balances.domain.entity.BalanceAccount;
import br.com.samuca.fceda.balances.domain.gateway.BalanceAccountGateway;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BalanceMongoAccountGateway implements BalanceAccountGateway {

    private final BalanceMongoRepository balanceMongoRepository;

    public BalanceMongoAccountGateway(BalanceMongoRepository balanceMongoRepository) {
        this.balanceMongoRepository = balanceMongoRepository;
    }

    @Override
    public void save(BalanceAccount balance) {
        BalanceDocument document = new BalanceDocument(balance.getAccountId(), balance.getBalance());
        balanceMongoRepository.save(document);
    }

    @Override
    public Optional<BalanceAccount> findByAccountId(String accountId) {
        BalanceDocument document = balanceMongoRepository.findByAccountId(accountId);
        if (document == null) {
            return Optional.empty();
        }

        return Optional.of(new BalanceAccount(document.getAccountId(), document.getBalance()));
    }

}
