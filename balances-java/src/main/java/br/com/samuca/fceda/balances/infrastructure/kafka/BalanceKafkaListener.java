package br.com.samuca.fceda.balances.infrastructure.kafka;

import br.com.samuca.fceda.balances.domain.dto.BalanceAccountDto;
import br.com.samuca.fceda.balances.domain.usecase.SaveBalanceAccountUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BalanceKafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(BalanceKafkaListener.class);

    private final SaveBalanceAccountUseCase saveBalanceAccountUseCase;
    private final ObjectMapper objectMapper;

    public BalanceKafkaListener(SaveBalanceAccountUseCase saveBalanceAccountUseCase, ObjectMapper objectMapper) {
        this.saveBalanceAccountUseCase = saveBalanceAccountUseCase;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "balances")
    public void listen(String message) {
        logger.info("Received message: {}", message);

        try {
            BalanceUpdatedDto balanceUpdatedDto = objectMapper.readValue(message, BalanceUpdatedDto.class);
            logger.info("BalanceUpdatedDto: {}", balanceUpdatedDto);

            logger.info("Salvando balance account from");
            BalanceAccountDto balanceAccountDtoFrom = new BalanceAccountDto(balanceUpdatedDto.account_id_from(), balanceUpdatedDto.balance_account_id_from());
            saveBalanceAccountUseCase.process(balanceAccountDtoFrom);

            logger.info("Salvando balance account to");
            BalanceAccountDto balanceAccountDtoTo = new BalanceAccountDto(balanceUpdatedDto.account_id_to(), balanceUpdatedDto.balance_account_id_to());
            saveBalanceAccountUseCase.process(balanceAccountDtoTo);

        } catch (Exception e) {
            logger.error("Error converting message to BalanceUpdatedDto: {}", e.getMessage(), e);
        }

    }
}
