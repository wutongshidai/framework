package com.wutong.framework.core.web.common.advice;

import com.wutong.framework.core.web.common.http.HttpStatus;
import com.wutong.framework.core.web.common.http.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseResult<?> errorHandler(Exception ex) throws Exception {
		ResponseResult<?> responseResult = new ResponseResult<>();
		
		if (ex instanceof NoHandlerFoundException) {
			responseResult.setCode(HttpStatus.CODE404);
		} else {
			responseResult.setCode(HttpStatus.CODE500);
		}
		return responseResult;
	}
}
