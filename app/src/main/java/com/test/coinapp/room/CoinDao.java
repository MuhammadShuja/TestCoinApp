package com.test.coinapp.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CoinDao {
    @Query("SELECT * FROM coins")
    LiveData<List<Coin>> getAll();

    @Query("SELECT * FROM coins WHERE id = :id")
    LiveData<Coin> get(int id);

    @Insert
    void insertAll(List<Coin> coins);

    @Update
    void update(Coin coin);

    @Query("DELETE FROM coins")
    void deleteAll();
}
