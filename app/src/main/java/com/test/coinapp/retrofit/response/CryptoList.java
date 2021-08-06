package com.test.coinapp.retrofit.response;

import com.google.gson.annotations.SerializedName;
import com.test.coinapp.room.Coin;

import java.util.ArrayList;
import java.util.List;

public class CryptoList {
    @SerializedName("status")
    private Status status;

    @SerializedName("data")
    private List<Datum> data;

    public Status getStatus() {
        return status;
    }

    public List<Datum> getData() {
        return data;
    }

    public List<Coin> getCoins() {
        List<Coin> coins = new ArrayList<>();
        for (Datum datum : data) {
            coins.add(
                    new Coin(
                            datum.getId(),
                            datum.getName(),
                            datum.getSymbol(),
                            datum.getSlug(),
                            datum.getCirculatingSupply(),
                            datum.getTotalSupply(),
                            datum.getMaxSupply(),
                            datum.getDateAdded(),
                            datum.getNumMarketPairs(),
                            datum.getCmcRank(),
                            datum.getLastUpdated(),
                            datum.getQuote().getUSD().getPrice(),
                            datum.getQuote().getUSD().getVolume24h(),
                            datum.getQuote().getUSD().getPercentChange1h(),
                            datum.getQuote().getUSD().getPercentChange24h(),
                            datum.getQuote().getUSD().getPercentChange7d(),
                            datum.getQuote().getUSD().getMarketCap()
                    ));
        }

        return coins;
    }

}