package com.test.coinapp.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.test.coinapp.R;
import com.test.coinapp.room.CoinViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CoinViewModel coinViewModel;

    private CoinAdapter coinAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coinViewModel = new ViewModelProvider(this).get(CoinViewModel.class);

        initViews();
        loadData();
    }

    private void initViews() {
        coinAdapter = new CoinAdapter(new ArrayList<>(),
                coin -> Toast.makeText(this, coin.getName() + " clicked!", Toast.LENGTH_SHORT).show());

        final RecyclerView rvItems = findViewById(R.id.rv_items);
        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItems.setAdapter(coinAdapter);
        ((SimpleItemAnimator) rvItems.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    private void loadData() {
        coinViewModel.getCoins().observe(this, coins -> {
            coinAdapter.setData(coins);
            Toast.makeText(this, "Data updated!", Toast.LENGTH_SHORT).show();
        });
    }
}