package com.jnx.springboot.httprequest.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态枚举类
 * @author 蒋楠鑫
 * @date 2020/3/31
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    /**
     * 状态正常
     */
    OK(1,"正常"),

    /**
     * 状态警告
     */
    WARNING(2,"警告"),

    /**
     * 状态错误
     */
    ERROR(3,"错误");

    /**
     * 代码
     */
    private Integer code;

    /**
     * 中文值
     */
    private String value;
}
