package com.test.coinapp.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quote implements Serializable {

    @SerializedName("USD")
    private USD uSD;

    public USD getUSD() {
        return uSD;
    }
}