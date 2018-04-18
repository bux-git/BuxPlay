package com.example.lym.buxplay.bean;

import java.io.Serializable;

/**
 * @description：
 * @author：bux on 2018/4/18 10:40
 * @email: 471025316@qq.com
 */
public class BaseBean<T> implements Serializable {
    public static final int SUCCESS = 1;

    private int status;
    private T datas;
    private String message;

    public boolean isSuccess() {
        return status == SUCCESS;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
