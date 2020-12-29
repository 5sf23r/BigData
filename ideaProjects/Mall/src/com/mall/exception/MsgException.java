package com.mall.exception;

public class MsgException extends RuntimeException {
    public MsgException(){

    }

    /**
     * 错误提示
     * @param msg 错误提示信息
     */
    public MsgException(String msg) {
        super(msg);
    }

}
