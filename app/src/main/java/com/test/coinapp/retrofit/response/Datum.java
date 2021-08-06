package com.test.coinapp.retrofit.response;

import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("slug")
    private String slug;

    @SerializedName("circulating_supply")
    private Double circulatingSupply;

    @SerializedName("total_supply")
    private Double totalSupply;

    @SerializedName("max_supply")
    private Double maxSupply;

    @SerializedName("date_added")
    private String dateAdded;

    @SerializedName("num_market_pairs")
    private Integer numMarketPairs;

    @SerializedName("cmc_rank")
    private Integer cmcRank;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("quote")
    private Quote quote;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSlug() {
        return slug;
    }

    public Double getCirculatingSupply() {
        return circulatingSupply;
    }

    public Double getTotalSupply() {
        return totalSupply;
    }

    public Double getMaxSupply() {
        return maxSupply;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public Integer getNumMarketPairs() {
        return numMarketPairs;
    }

    public Integer getCmcRank() {
        return cmcRank;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Quote getQuote() {
        return quote;
    }
}