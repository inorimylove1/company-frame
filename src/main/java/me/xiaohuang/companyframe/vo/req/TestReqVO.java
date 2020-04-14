package me.xiaohuang.companyframe.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName TestReqVO
 * @Description TestReqVO
 * @Author xiaohuang
 * @Date 2020/4/8 10:24
 * @Version 1.0
 */
@Data
public class TestReqVO {
    @ApiModelProperty(value = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    @NotNull(message = "age 不能为空")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @NotEmpty(message = "id 集合不能为空")
    @ApiModelProperty(value = "id集合")
    private List<String> ids;


}
