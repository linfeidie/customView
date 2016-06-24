package com.stay4it.testrxjavaandretrofit.http;


public class LoginResponse<T> {

    private String status;
    private int code;
    private String message;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private boolean isSuccess() {
        return status.equals(Constant.HTTP_OK);
    }
}
