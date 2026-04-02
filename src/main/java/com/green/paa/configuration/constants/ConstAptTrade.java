package com.green.paa.configuration.constants;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@RequiredArgsConstructor
@ConfigurationProperties(prefix = "constants.open-feign.apt-trade")
public class ConstAptTrade {
    public final String serviceKey;
}
