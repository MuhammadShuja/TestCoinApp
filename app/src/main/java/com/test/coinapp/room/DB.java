package com.test.coinapp.room;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Coin.class}, version = 1)
public abstract class DB extends RoomDatabase {
    private static final String TAG = "DB";

    // DB INFO
    private static final String databaseName = "coin_database";
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    // INSTANCE
    private static volatile DB INSTANCE;

    public static DB getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (DB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DB.class, databaseName)
                            .build();
                    Log.d(TAG, "New instance created...");
                }
            }
        }
        return INSTANCE;
    }

    // DAOs
    public abstract CoinDao coinDao();
}
