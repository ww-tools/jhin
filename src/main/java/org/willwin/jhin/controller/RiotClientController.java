package org.willwin.jhin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.model.domain.account.Account;
import org.willwin.jhin.riot.RiotClient;

@RestController
@RequestMapping("/riot")
@RequiredArgsConstructor
class RiotClientController
{

    private final RiotClient riotClient;

    @GetMapping("/account/by-riot-id/{gameName}/{tagLine}")
    ResponseEntity<Account> getAccountByRiotId(
            @PathVariable String gameName,
            @PathVariable String tagLine)
    {
        return ResponseEntity.ok(
                riotClient.getAccountByRiotId(Platform.NA1, gameName, tagLine));
    }

}
