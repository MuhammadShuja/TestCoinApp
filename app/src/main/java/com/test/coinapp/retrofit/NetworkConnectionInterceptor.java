package com.test.coinapp.retrofit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.test.coinapp.CoinApp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkConnectionInterceptor implements Interceptor {

    public NetworkConnectionInterceptor() {
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        if (!isConnected())
            throw new NoConnectivityException();

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager =
                ((ConnectivityManager) CoinApp.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public static class NoConnectivityException extends IOException {
        @Override
        public String getMessage() {
            return "No network available, please check your WiFi or Data connection";
        }
    }
}