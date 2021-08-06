package com.test.coinapp.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Status implements Serializable {
    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("error_code")
    private Integer errorCode;

    @SerializedName("error_message")
    private Object errorMessage;

    @SerializedName("elapsed")
    private Integer elapsed;

    @SerializedName("credit_count")
    private Integer creditCount;

    public String getTimestamp() {
        return timestamp;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public Integer getElapsed() {
        return elapsed;
    }

    public Integer getCreditCount() {
        return creditCount;
    }
}