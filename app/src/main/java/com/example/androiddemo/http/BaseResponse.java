package com.example.androiddemo.http;

import java.io.Serializable;

/**
 * @author: mlsnatalie
 * @date: 2021/3/9 6:44 PM
 * @UpdateDate: 2021/3/9 6:44 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class BaseResponse<T> implements Serializable {
    private T data;
    private int errorCode;
    private String errorMsg;

    public BaseResponse() {}

    public BaseResponse(int errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
