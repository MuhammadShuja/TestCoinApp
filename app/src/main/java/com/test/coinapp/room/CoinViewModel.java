package com.test.coinapp.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CoinViewModel extends AndroidViewModel {
    private final CoinRepository repository;
    private final LiveData<List<Coin>> coins;

    public CoinViewModel(@NonNull Application application) {
        super(application);
        repository = new CoinRepository(application);
        coins = repository.getCoins();
    }

    public LiveData<List<Coin>> getCoins() {
        return coins;
    }

    public LiveData<Coin> getCoin(int id) {
        return repository.getCoin(id);
    }
}
