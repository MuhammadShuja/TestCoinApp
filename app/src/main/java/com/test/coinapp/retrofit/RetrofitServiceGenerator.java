package com.test.coinapp.retrofit;

import androidx.multidex.BuildConfig;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenerator {
    public static <T> T generate(Class<T> serviceClass, String baseUrl) {
        OkHttpClient.Builder httpBuilder =
                new OkHttpClient.Builder();

        httpBuilder.connectionPool(new ConnectionPool(0, 1, TimeUnit.NANOSECONDS));
        httpBuilder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        httpBuilder.readTimeout(100, TimeUnit.SECONDS);
        httpBuilder.writeTimeout(100, TimeUnit.SECONDS);
        httpBuilder.connectTimeout(100, TimeUnit.SECONDS);

        httpBuilder.addInterceptor(new NetworkConnectionInterceptor());

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpBuilder.addInterceptor(interceptor);
        }

        OkHttpClient httpClient = httpBuilder.build();

        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(httpClient)
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        return retrofit.create(serviceClass);
    }
}
