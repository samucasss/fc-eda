package br.com.samuca.fceda.balances.infrastructure.kafka;

public record BalanceUpdatedDto(String account_id_from, String account_id_to, Double balance_account_id_from,
                                Double balance_account_id_to) {
}
