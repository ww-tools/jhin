package org.willwin.jhin.client.riot.account;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.willwin.jhin.domain.riot.account.Account;
import reactor.core.publisher.Mono;

@HttpExchange("https://{host}/riot/account/v1/")
public interface AccountClient
{

    @GetExchange("/accounts/by-puuid/{puuid}")
    Mono<ResponseEntity<@NonNull Account>> getAccountByPuuid(
            @PathVariable String host,
            @PathVariable String puuid);

    @GetExchange("/accounts/by-riot-id/{gameName}/{tagLine}")
    Mono<ResponseEntity<@NonNull Account>> getAccountByRiotId(
            @PathVariable String host,
            @PathVariable String gameName,
            @PathVariable String tagLine);

}
