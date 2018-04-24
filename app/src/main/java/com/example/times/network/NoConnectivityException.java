package com.example.times.network;

import com.example.times.utils.Constants;

import java.io.IOException;

/**
 * Created by Karishma on 14/4/18.
 */

public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return Constants.NO_INTERNET;
    }
}
