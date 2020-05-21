package com.jnx.springboot.common.exception;

import com.jnx.springboot.common.constant.InfoMsgEnum;
import com.jnx.springboot.common.message.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获机制
 *
 * @author 蒋楠鑫
 * @date 2020/5/15
 */
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(BussinessException.class)
	@ResponseBody
	public Result<String> defaultExceptionHandler(BussinessException exception) {
		exception.printStackTrace();
		return Result.error(InfoMsgEnum.INTERNAL_SERVER_ERROR.code, exception.getMessage());
	}
}
