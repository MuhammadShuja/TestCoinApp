package com.test.coinapp.retrofit;

import android.util.Log;

import com.test.coinapp.retrofit.response.CryptoList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public class RetrofitService {
    public static final String API_HOST = "https://pro-api.coinmarketcap.com";
    private static final String TAG = "RetrofitService";
    private static Client client = null;

    public static synchronized Client getClient() {
        if (client == null) {
            client = RetrofitServiceGenerator.generate(Client.class, API_HOST);
            Log.d(TAG, "Service generated...");
        }
        return client;
    }

    public interface Client {
        @Headers("X-CMC_PRO_API_KEY: 3069b872-06b0-40f1-bf44-5a3f7f73d796")
        @GET("/v1/cryptocurrency/listings/latest")
        Observable<CryptoList> getLatest(@Query("limit") int limit);
    }
}
