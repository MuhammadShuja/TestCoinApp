package com.test.coinapp.retrofit.response;

import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("USD")
    private USD uSD;

    public USD getUSD() {
        return uSD;
    }
}