package me.xiaohuang.companyframe.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.xiaohuang.companyframe.exception.BusinessException;
import me.xiaohuang.companyframe.exception.code.BaseResponseCode;
import me.xiaohuang.companyframe.utils.DataResult;
import me.xiaohuang.companyframe.vo.req.TestReqVO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TestController
 * @Author xiaohuang
 * @Date 2020/4/6 19:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试相关的模块")
public class TestController {
    @GetMapping("/index")
    @ApiOperation(value = "Swagger 测试index接口")
    public String testResult() {
        return "hello world";
    }

    @GetMapping("/home")
    @ApiOperation("value=测试统一格式接口")
    public DataResult getHome() {
//        DataResult result=DataResult.success();
        DataResult result = DataResult.getResult(BaseResponseCode.DATA_ERROR);
//        result.setData("成功了");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        result.setData(list);
//        int i=1/0;
        return result;
    }

    @GetMapping("/business/error")
    @ApiOperation(value = "测试主动抛出业务异常")
    public DataResult<String> testBusinessError(@RequestParam String type) {
        if (!type.equals("1") || type.equals("2") || type.equals("3")) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        DataResult<String> result = new DataResult(0, type);
        return result;
    }

    @PostMapping("/valid/error")
    @ApiOperation(value = "测试Validator抛出业务异常接口")
    public DataResult testValid(@RequestBody @Valid TestReqVO vo){
        DataResult result=DataResult.success();
        return result;
    }


}
