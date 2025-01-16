package br.com.samuca.fceda.balances.api;

import br.com.samuca.fceda.balances.domain.dto.BalanceAccountDto;
import br.com.samuca.fceda.balances.domain.usecase.FindBalanceAccountUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BalanceAccountRestController {

    private final FindBalanceAccountUseCase findBalanceAccountUseCase;

    public BalanceAccountRestController(FindBalanceAccountUseCase findBalanceAccountUseCase) {
        this.findBalanceAccountUseCase = findBalanceAccountUseCase;
    }

    @GetMapping("/balances/{accountId}")
    public ResponseEntity<BalanceAccountDto> find(@PathVariable String accountId) {
        Optional<BalanceAccountDto> balanceAccountDto = findBalanceAccountUseCase.find(accountId);
        if (balanceAccountDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(balanceAccountDto.get());
    }
}
