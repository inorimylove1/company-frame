package me.xiaohuang.companyframe.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xiaohuang.companyframe.constants.Constant;
import me.xiaohuang.companyframe.entity.SysUser;
import me.xiaohuang.companyframe.exception.code.BaseResponseCode;
import me.xiaohuang.companyframe.service.UserSevice;
import me.xiaohuang.companyframe.utils.DataResult;
import me.xiaohuang.companyframe.vo.req.LoginReqVO;
import me.xiaohuang.companyframe.vo.req.UserPageReqVO;
import me.xiaohuang.companyframe.vo.resp.LoginRespVO;
import me.xiaohuang.companyframe.vo.resp.PageVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @ClassName UserController
 * @Description UserController
 * @Author xiaohuang
 * @Date 2020/4/8 15:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
@Api(tags="用户模块相关接口")
public class UserController {
    @Autowired
    private UserSevice userService;
    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录接口")
    public DataResult<LoginRespVO> login(@RequestBody @Valid LoginReqVO vo){
        DataResult result=DataResult.success();
        result.setData(userService.login(vo));
        return result;
    }

    @GetMapping("/user/logout")
    @ApiOperation(value = "用户登出接口")
    public DataResult logout(HttpServletRequest request){
        String accessToken=request.getHeader(Constant.ACCESS_TOKEN);
        String refreshToken=request.getHeader(Constant.REFRESH_TOKEN);
        userService.logout(accessToken,refreshToken);
        return DataResult.success();
    }

    @GetMapping("/user/unLogin")
    @ApiOperation(value = "引导客户端去登录")
    public DataResult unLogin(){
        DataResult result= DataResult.getResult(BaseResponseCode.TOKEN_ERROR);
        return result;
    }


    @PostMapping("/users")
    @ApiOperation(value = "分页查询用户接口")
    @RequiresPermissions("sys:user:list")
    public DataResult<PageVO<SysUser>> pageInfo(@RequestBody UserPageReqVO vo){
        DataResult result=DataResult.success();
        result.setData(userService.pageInfo(vo));
        return result;
    }
}
