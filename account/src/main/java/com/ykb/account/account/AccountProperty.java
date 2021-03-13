package com.ykb.account.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "accounts")
@Data
@NoArgsConstructor
public class AccountProperty {

    private List<AccountInfo> accountInfoList;
    private String password;
}
