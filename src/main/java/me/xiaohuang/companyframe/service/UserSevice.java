package me.xiaohuang.companyframe.service;

import me.xiaohuang.companyframe.entity.SysUser;
import me.xiaohuang.companyframe.vo.req.LoginReqVO;
import me.xiaohuang.companyframe.vo.req.UserPageReqVO;
import me.xiaohuang.companyframe.vo.resp.LoginRespVO;
import me.xiaohuang.companyframe.vo.resp.PageVO;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserSevice
 * @Description UserSevice
 * @Author xiaohuang
 * @Date 2020/4/8 15:25
 * @Version 1.0
 */
public interface UserSevice {
    LoginRespVO login(LoginReqVO vo);
    void logout(String accessToken,String refreshToken);
    PageVO<SysUser> pageInfo(UserPageReqVO vo);
}
