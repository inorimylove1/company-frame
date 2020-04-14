package me.xiaohuang.companyframe.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ClassName CustomUsernamePasswordToken
 * @Description CustomUsernamePasswordToken
 * @Author xiaohuang
 * @Date 2020/4/8 17:18
 * @Version 1.0
 */
public class CustomUsernamePasswordToken extends UsernamePasswordToken {
    private String token;

    public CustomUsernamePasswordToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }
}
