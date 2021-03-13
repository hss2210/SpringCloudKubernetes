package com.ykb.credit.credit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service")
public interface AccountClient {

    @GetMapping("account/info/{accountNo}")
    AccountInfo getAccountInfo(@PathVariable("accountNo") String accountNo);

}
