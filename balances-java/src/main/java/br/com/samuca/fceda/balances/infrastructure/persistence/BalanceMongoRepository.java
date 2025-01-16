package br.com.samuca.fceda.balances.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BalanceMongoRepository extends MongoRepository<BalanceDocument, String> {

    BalanceDocument findByAccountId(String accountId);
}
