package com.springboot.project.exception;

import com.springboot.project.Util.Result;
import com.springboot.project.enums.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.StreamSupport;

/**
 * <p>
 * 异常基类
 * </p>
 * @description: 异常基类
 */
@ControllerAdvice
@Slf4j
public class GlobalException{

	/**
	 * 处理自定义异常
	 *
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = FreeException.class)
	@ResponseBody
	public Result freeExceptionHandler(FreeException e) {
		log.error("FreeException：", e);
		return new Result(e.getCode(),null,null);
	}

	/**
	 * 其他异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result exceptionHandler(Exception e) {
		log.error("Exception：", e);
		return  Result.Error(Status.UNKNOWN_ERROR.getCode(), e.getMessage(),null);
	}
}
