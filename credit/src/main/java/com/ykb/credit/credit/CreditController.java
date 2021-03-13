package com.ykb.credit.credit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/credit")
public class CreditController {

    private final AccountClient accountClient;
    private final CreditProperty creditProperty;
    private final RestTemplate restTemplate;

    public CreditController(AccountClient accountClient, CreditProperty creditProperty, RestTemplate restTemplate) {
        this.accountClient = accountClient;
        this.creditProperty = creditProperty;
        this.restTemplate = restTemplate;
    }

    @GetMapping("infoViaFeign")
    public CreditInfoResponse getCreditInfoViaFeign(String creditNo) {

        for (CreditInfo creditInfo : creditProperty.getCreditInfoList()) {
            if(creditInfo.getCreditNo().equals(creditNo)) {
                AccountInfo accountInfo = accountClient.getAccountInfo(creditInfo.getAccountNo());
                return new CreditInfoResponse(creditNo, accountInfo.getAccountNo(), accountInfo.getBalance(), accountInfo.getCurrency(), accountInfo.getCustomerCode());
            }
        }
        return null;
    }

    @GetMapping("info")
    public CreditInfoResponse getCreditInfo(String creditNo) {

        for (CreditInfo creditInfo : creditProperty.getCreditInfoList()) {
            if(creditInfo.getCreditNo().equals(creditNo)) {
                AccountInfo accountInfo = restTemplate.getForObject("http://account-service/account/info/{accountNo}", AccountInfo.class, creditInfo.getAccountNo());
                return new CreditInfoResponse(creditNo, accountInfo.getAccountNo(), accountInfo.getBalance(), accountInfo.getCurrency(), accountInfo.getCustomerCode());
            }
        }
        return null;
    }
}
