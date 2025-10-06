package org.willwin.jhin.feign.account;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.willwin.jhin.model.domain.account.Account;
import org.willwin.jhin.riot.RiotFeignConfiguration;

import java.net.URI;

@FeignClient(
        name = "accountClient",
        url = "${riot.default-api-url:}",
        configuration = RiotFeignConfiguration.class
)
public interface AccountClient
{

    @RateLimiter(name = "get-account-by-puuid")
    @CircuitBreaker(name = "get-account-by-puuid")
    @Retry(name = "get-account-by-puuid")
    @GetMapping("/riot/account/v1/accounts/by-puuid/{puuid}")
    ResponseEntity<@NonNull Account> getAccountByPuuid(
            URI host,
            @PathVariable String puuid);

    @RateLimiter(name = "get-account-by-riot-id")
    @CircuitBreaker(name = "get-account-by-riot-id")
    @Retry(name = "get-account-by-riot-id")
    @GetMapping("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    ResponseEntity<@NonNull Account> getAccountByRiotId(
            URI host,
            @PathVariable String gameName,
            @PathVariable String tagLine);

}
