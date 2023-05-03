package com.myframework.mybackend.framework.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommonResult {
	
	@ApiModelProperty(value = "���� �������� : true/false")
    private boolean success;

    @ApiModelProperty(value = "���� �ڵ� ��ȣ : > 0 ����, < 0 ������")
    private int code;

    @ApiModelProperty(value = "���� �޽���")
    private String msg;
}