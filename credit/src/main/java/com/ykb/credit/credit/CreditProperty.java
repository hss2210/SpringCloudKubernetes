package com.ykb.credit.credit;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "credits")
@Data
@NoArgsConstructor
public class CreditProperty {

    private List<CreditInfo> creditInfoList;
}
