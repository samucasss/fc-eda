package br.com.samuca.fceda.balances.infrastructure.api;

import br.com.samuca.fceda.balances.domain.dto.BalanceAccountDto;
import br.com.samuca.fceda.balances.domain.entity.BalanceAccount;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BalanceAccountRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    @SneakyThrows
    void setUp() {
        BalanceAccount balanceAccount = new BalanceAccount("123", 100.0);
        mongoTemplate.save(balanceAccount, "balances");
    }

    @AfterEach
    @SneakyThrows
    void finish() {
        mongoTemplate.dropCollection("balances");
    }

    @Test
    void find() {
        ResponseEntity<BalanceAccountDto> response = restTemplate.getForEntity("/balances/123", BalanceAccountDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("123", response.getBody().accountId());
        assertEquals(100.0, response.getBody().balance());
    }
}