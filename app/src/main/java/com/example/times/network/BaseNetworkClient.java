package com.example.times.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.times.utils.Constants;

import java.io.IOException;

import retrofit2.HttpException;

/**
 * Created by Karishma on 14/4/18.
 */

public abstract class BaseNetworkClient {

    protected Context mContext;

    public BaseNetworkClient(Context context) {
        mContext = context;
    }

    /**
     * Generic error handler.
     *
     * @param throwable the exception.
     */
    public void handleError(Throwable throwable) {
        Log.e("ERROR", "Error msg"+throwable.getMessage());
        throwable.printStackTrace();
        if(throwable instanceof NoConnectivityException) {
            showAppError(throwable.getMessage());
        }else if(throwable instanceof IOException){
            showAppError(Constants.CONNECT_INTERNET);
        }else if(throwable instanceof HttpException){
            showAppError(throwable.getMessage());
        }else {
            showAppError(throwable.getMessage());
        }
    }


    protected void showAppError(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }
}
