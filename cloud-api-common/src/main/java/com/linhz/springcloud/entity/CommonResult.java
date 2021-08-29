package com.linhz.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    // 无data返回构造器
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
