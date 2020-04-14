package me.xiaohuang.companyframe.utils;

import org.springframework.stereotype.Component;

/**
 * @ClassName InitializerUtil
 * @Description InitializerUtil
 * @Author xiaohuang
 * @Date 2020/4/8 13:03
 * @Version 1.0
 */
@Component
public class InitializerUtil {
    private TokenSettings tokenSettings;
    public InitializerUtil(TokenSettings tokenSettings){
        JwtTokenUtil.setTokenSettings(tokenSettings);
    }
}
