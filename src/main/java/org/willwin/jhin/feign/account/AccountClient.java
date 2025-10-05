package org.willwin.jhin.feign.account;

import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.willwin.jhin.model.domain.account.Account;

import java.net.URI;

@FeignClient("account-client")
public interface AccountClient
{

    @GetMapping("/riot/account/v1/accounts/by-puuid/{puuid}")
    ResponseEntity<@NonNull Account> getAccountByPuuid(
            URI host,
            @PathVariable String puuid);

    @GetExchange("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    ResponseEntity<@NonNull Account> getAccountByRiotId(
            URI host,
            @PathVariable String gameName,
            @PathVariable String tagLine);

}
