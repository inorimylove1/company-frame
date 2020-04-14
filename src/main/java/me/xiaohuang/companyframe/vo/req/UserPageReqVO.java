package me.xiaohuang.companyframe.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName UserPageReqVO
 * @Description UserPageReqVO
 * @Author xiaohuang
 * @Date 2020/4/8 16:31
 * @Version 1.0
 */
@Data
public class UserPageReqVO {
    @ApiModelProperty(value = "当前第几页")
    private Integer pageNum=1;

    @ApiModelProperty(value = "当前页数量")
    private Integer pageSize=10;
}
