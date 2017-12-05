package com.wutong.framework.core.web.common.payment;

public enum PayStatus {
    UNPAID(10000, "初始订单"), PAID_OFF(10001, "已支付"), NON_PAYMENT(10002, "不可支付"), PAID_SUCCESS(10003, "支付成功"), PAID_FAIL(10004, "支付失败"), 
    ORDER_UNEXISTS(10005, "订单不存在");

    private int code;

    private String message;

    private PayStatus(int code, String message) {
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
