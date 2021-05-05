package com.example.batchrenamepicture.result;

/**
 * 响应码枚举，对应HTTP状态码
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code){
        this.code = code;
    }
}
