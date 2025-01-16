package br.com.samuca.fceda.balances.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "balances")
@AllArgsConstructor
public class BalanceDocument {

    private String accountId;
    private Double balance;
}