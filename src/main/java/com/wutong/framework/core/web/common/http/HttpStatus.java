package com.wutong.framework.core.web.common.http;

public enum HttpStatus {

	CODE400(400, "请求无效"), CODE403(403, "禁止访问"), CODE404(404, "资源未找到"), CODE500(500, "内部服务器错误"), CODE200(200, "成功"), CODE202(202, "用户未登录"), CODE203(203, "数据不存在");
	
	private int code;
	
	private String message;
	
	private HttpStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int code() {
		return this.code;
	}
	
	public String message() {
		return this.message;
	}
}
