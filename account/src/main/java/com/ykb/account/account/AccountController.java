package com.ykb.account.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountProperty accountProperty;

    public AccountController(AccountProperty accountProperty) {
        this.accountProperty = accountProperty;
    }

    @GetMapping("info/{accountNo}")
    public AccountInfo getAccountInfo(@PathVariable String accountNo) {
        log.info("***********secret********** : " + accountProperty.getPassword());
        for (AccountInfo accountInfo : accountProperty.getAccountInfoList()) {
            if(accountInfo.getAccountNo().equals(accountNo)) {
                return accountInfo;
            }
        }
        return null;
    }
}
