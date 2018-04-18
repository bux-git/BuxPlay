package com.example.lym.buxplay.common.rx;

import android.content.Context;
import android.widget.Toast;

import com.example.lym.buxplay.common.exception.ApiException;
import com.example.lym.buxplay.common.exception.BaseException;
import com.example.lym.buxplay.common.exception.ErrorMessageFactory;
import com.example.lym.buxplay.common.exception.ExCodeConstant;
import com.google.gson.JsonParseException;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;


/**
 * @description：
 * @author：bux on 2018/4/18 16:30
 * @email: 471025316@qq.com
 */
public class RxErrorHandler {
    private Context mContext;

    public RxErrorHandler(Context context) {
        mContext = context;
    }

    public BaseException handlerError(Throwable e) {
        BaseException exception = new BaseException();

        if (e instanceof ApiException) {

            return (BaseException) e;

        } else if (e instanceof JsonParseException) {
            exception.setCode(ExCodeConstant.JSON_ERROR);
        } else if (e instanceof HttpException) {

            exception.setCode(((HttpException) e).code());
        } else if (e instanceof SocketTimeoutException) {

            exception.setCode(ExCodeConstant.SOCKET_TIMEOUT_ERROR);
        } else if (e instanceof SocketException) {
            exception.setCode(ExCodeConstant.SOCKET_ERROR);

        } else {
            exception.setCode(ExCodeConstant.UNKNOWN_ERROR);

        }

        exception.setDisplayMessage(ErrorMessageFactory.create(mContext, exception.getCode()));
        return exception;
    }

    public void showErrorMessage(BaseException e) {

        Toast.makeText(mContext, e.getDisplayMessage(), Toast.LENGTH_LONG).show();
    }
}
