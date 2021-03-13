package com.ykb.credit.credit;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditInfoResponse {

    public CreditInfoResponse () { }

    public CreditInfoResponse (String creditNo, String accountNo, BigDecimal balance, String currency, Long customerCode) {
        this.creditNo = creditNo;
        this.accountNo = accountNo;
        this.balance = balance;
        this.currency = currency;
        this.customerCode = customerCode;
    }

    private String creditNo;
    private String accountNo;
    private BigDecimal balance;
    private String currency;
    private Long customerCode;
}
