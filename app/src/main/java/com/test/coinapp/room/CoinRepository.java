package com.test.coinapp.room;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.test.coinapp.retrofit.RetrofitService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;

public class CoinRepository {
    private static final String TAG = "Repo/Coin";

    private final CoinDao coinDao;
    private final LiveData<List<Coin>> coins;

    public CoinRepository(Application application) {
        coinDao = DB.getInstance(application).coinDao();
        coins = coinDao.getAll();

        loadCoinsPeriodically();

        Log.d(TAG, "New instance created...");
    }

    public LiveData<List<Coin>> getCoins() {
        return coins;
    }

    private void loadCoinsPeriodically() {
        Observable.interval(0, 1, TimeUnit.MINUTES)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        aLong ->
                                RetrofitService.getClient().getLatest(500)
                                        .subscribeOn(AndroidSchedulers.mainThread())
                                        .subscribe(
                                                cryptoList ->
                                                        DB.databaseWriteExecutor.submit(() -> {
                                                            coinDao.deleteAll();
                                                            coinDao.insertAll(cryptoList.getCoins());

                                                            Log.d(TAG, "Data inserted in \"coins\" table");
                                                        }),
                                                throwable ->
                                                        Log.d(TAG, "API observable error: " + throwable.getMessage())),
                        throwable ->
                                Log.d(TAG, "Periodic observable error: " + throwable.getMessage()));
    }

    public LiveData<Coin> getCoin(int id) {
        return coinDao.get(id);
    }
}