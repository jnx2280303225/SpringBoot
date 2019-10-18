package com.jnx.springboot.common.msg;

import com.jnx.springboot.common.constant.InfoMsgEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一前端返回对象
 *
 * @author hutu
 * @date 2018/7/19 17:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("返回结果")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("返回状态码")
    private Integer code;
    
    @ApiModelProperty("返回消息")
    private String msg;
    
    @ApiModelProperty("业务数据")
    private T data;
    
    @ApiModelProperty("总记录数")
    private Long total;
    
    @ApiModelProperty("其他内容")
    private  Map<String, Object> extra = new HashMap<>();

    /**
     * 无参构造器:code:200,message:成功
     */
    public Result() {
        this.code = InfoMsgEnum.OK.code;
        this.msg = InfoMsgEnum.OK.msg;
    }

    /**
     * 失败  默认：code:500,message:系统内容错误
     * 如果参数带有自定义信息枚举ErrorMsgEnum，code取参数枚举的code，message取参数枚举的desc
     * 如果参数带有String msg，message取参数msg
     */
    public static Result error() {
        return error(InfoMsgEnum.INTERNAL_SERVER_ERROR.code,InfoMsgEnum.INTERNAL_SERVER_ERROR.msg);
    }

    public static Result error(Integer code,String msg) {
        Result r = new Result();
        r.code = code;
        r.msg = msg;
        return r;
    }
    
    public static Result error(String msg) {
        Result r = new Result();
        r.code = InfoMsgEnum.INTERNAL_SERVER_ERROR.code;
        r.msg = msg;
        return r;
    }
    
    public static <T> Result<T> error(String msg,T data) {
        Result<T> r = new Result<>();
        r.code = InfoMsgEnum.INTERNAL_SERVER_ERROR.code;
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.msg = msg;
        return r;
    }

    public static <T> Result<T> ok(String msg, T data) {
        Result<T> r = new Result<>();
        r.msg = msg;
        r.data = data;
        return r;
    }

    public static <T> Result<T> ok(String msg, T data, Long total) {
        Result<T> r = new Result<>();
        r.msg = msg;
        r.data = data;
        r.total = total;
        return r;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> r = new Result<>();
        r.data = data;
        return r;
    }

    public static <T> Result<T> ok(T data, Long total) {
        Result<T> r = new Result<>();
        r.data = data;
        r.total = total;
        return r;
    }

    /**
     *  其他信息，写入extra
     */
    public Result<T> put(String key, Object value) {
        this.extra.put(key, value);
        return this;
    }

}
