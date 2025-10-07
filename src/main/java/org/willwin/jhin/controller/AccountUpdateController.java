package org.willwin.jhin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.willwin.jhin.model.document.account.AccountDocument;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.service.AccountUpdateService;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
class AccountUpdateController
{

    private final AccountUpdateService accountUpdateService;

    @PostMapping("/update/{puuid}")
    ResponseEntity<AccountDocument> updateAccount(
            @PathVariable String puuid)
    {
        return ResponseEntity.ok(
                accountUpdateService.updateAccount(Platform.NA1, puuid));
    }

}
