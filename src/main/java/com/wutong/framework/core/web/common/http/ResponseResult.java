package com.wutong.framework.core.web.common.http;


import com.wutong.framework.core.web.common.payment.PayStatus;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseResult<T> implements Serializable {

	public ResponseResult(){}

	public ResponseResult(HttpStatus httpStatus) {
		setCode(httpStatus);
	}

	public ResponseResult(PayStatus payStatus) {
		setCode(payStatus);
	}


	private int code = HttpStatus.CODE200.code();
	
	private String message = HttpStatus.CODE200.message();
	
	private T resultData;
	
	public int getCode() {
		return code;
	}

	public void setCode(HttpStatus httpStatus) {
		this.code = httpStatus.code();
		this.setMessage(httpStatus.message());
	}

	public void setCode(PayStatus payStatus) {
		this.code = payStatus.code();
		this.setMessage(payStatus.message());
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public void addData(T resultData) {
		this.resultData = resultData;
	}

	public T getResultData() {
		return resultData;
	}
	
}
