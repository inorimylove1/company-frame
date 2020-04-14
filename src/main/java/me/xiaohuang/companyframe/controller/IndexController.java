package me.xiaohuang.companyframe.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description IndexController
 * @Author xiaohuang
 * @Date 2020/4/10 12:09
 * @Version 1.0
 */
@Controller
@RequestMapping("/index")
@Api(tags = "视图", description = "跳转视图的控制器")
public class IndexController {

    @GetMapping("/404")
    @ApiOperation(value = "跳转404错误页面")
    public String error404() {
        return "error/404";
    }
}
