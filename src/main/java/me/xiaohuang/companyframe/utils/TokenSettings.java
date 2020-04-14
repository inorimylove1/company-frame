package me.xiaohuang.companyframe.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @ClassName TokenSettings
 * @Description TokenSettings
 * @Author xiaohuang
 * @Date 2020/4/8 12:58
 * @Version 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix="jwt")
public class TokenSettings {
    private String secretKey;
    private Duration accessTokenExpireTime;
    private Duration refreshTokenExpireTime;
    private Duration refreshTokenExpireAppTime;
    private String issuer;
}
