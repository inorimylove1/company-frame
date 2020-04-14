package me.xiaohuang.companyframe.vo.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName LoginRespVo
 * @Description LoginRespVo
 * @Author xiaohuang
 * @Date 2020/4/8 15:20
 * @Version 1.0
 */
@Data
public class LoginRespVO {
    @ApiModelProperty(value = "正常的业务token")
    private String accessToken;
    @ApiModelProperty(value = "刷新token")
    private String refreshToken;
    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "账号")
    private String username;
}