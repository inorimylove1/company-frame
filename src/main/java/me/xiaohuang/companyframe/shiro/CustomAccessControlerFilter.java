package me.xiaohuang.companyframe.shiro;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import me.xiaohuang.companyframe.constants.Constant;
import me.xiaohuang.companyframe.exception.BusinessException;
import me.xiaohuang.companyframe.exception.code.BaseResponseCode;
import me.xiaohuang.companyframe.utils.DataResult;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName CustomAccessControlerFilter
 * @Description CustomAccessControlerFilter
 * @Author xiaohuang
 * @Date 2020/4/8 17:19
 * @Version 1.0
 */
@Slf4j
public class CustomAccessControlerFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info(request.getMethod());
        log.info(request.getRequestURL().toString());
        //判断客户端是否携带accessToken
        try {
            String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
            if (StringUtils.isEmpty(accessToken)) {
                throw new BusinessException(BaseResponseCode.TOKEN_NOT_NULL);
            }
            CustomUsernamePasswordToken customUsernamePasswordToken = new CustomUsernamePasswordToken(accessToken);
            getSubject(servletRequest, servletResponse).login(customUsernamePasswordToken);
        } catch (BusinessException e) {
            customRsponse(e.getCode(), e.getDefaultMessage(), servletResponse);
            return false;
        } catch (AuthenticationException e) {
            if (e.getCause() instanceof BusinessException) {
                BusinessException exception = (BusinessException) e.getCause();
                customRsponse(exception.getCode(), exception.getDefaultMessage(), servletResponse);
            } else {
                customRsponse(BaseResponseCode.SHIRO_AUTHENTICATION_ERROR.getCode(), BaseResponseCode.SHIRO_AUTHENTICATION_ERROR.getMsg(), servletResponse);
            }
            return false;
        }
        return true;
    }

    /**
     * 自定义错误响应
     *
     * @param code
     * @param msg
     * @param response
     * @return void
     * @throws
     * @Author: xiaohuang
     * @UpdateUser:
     * @Version: 0.0.1
     */
    private void customRsponse(int code, String msg, ServletResponse response) {
        // 自定义异常的类，用户返回给客户端相应的JSON格式的信息
        try {
            DataResult result = DataResult.getResult(code, msg);
            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");

            String userJson = JSON.toJSONString(result);
            OutputStream out = response.getOutputStream();
            out.write(userJson.getBytes("UTF-8"));
            out.flush();
        } catch (IOException e) {
            log.error("eror={}", e);
        }
    }
}
