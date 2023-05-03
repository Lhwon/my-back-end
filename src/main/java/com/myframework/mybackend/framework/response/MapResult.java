package com.myframework.mybackend.framework.response;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapResult<String, Object> extends CommonResult {
    private Map<String, Object> map;
}