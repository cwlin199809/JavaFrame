package com.cwlin.swagger.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Api(tags = "实体类")
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("密码")
    private String pwd;
    @ApiModelProperty("权限")
    private String perms;
}
