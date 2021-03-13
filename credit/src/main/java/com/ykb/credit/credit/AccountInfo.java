package com.ykb.credit.credit;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AccountInfo {

    private String accountNo;
    private BigDecimal balance;
    private String currency;
    private Long customerCode;
}
