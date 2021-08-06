package com.test.coinapp.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "coins")
public class Coin {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "symbol")
    public String symbol;

    @ColumnInfo(name = "slug")
    public String slug;

    @ColumnInfo(name = "circulating_supply")
    public Double circulatingSupply;

    @ColumnInfo(name = "total_supply")
    public Double totalSupply;

    @ColumnInfo(name = "max_supply")
    public Double maxSupply;

    @ColumnInfo(name = "date_added")
    public String dateAdded;

    @ColumnInfo(name = "num_market_pairs")
    public Integer numMarketPairs;

    @ColumnInfo(name = "cmc_rank")
    public Integer cmcRank;

    @ColumnInfo(name = "last_updated")
    public String lastUpdated;

    @ColumnInfo(name = "price")
    public Double price;

    @ColumnInfo(name = "volume_24h")
    public Double volume24h;

    @ColumnInfo(name = "percent_change_1h")
    public Double percentChange1h;

    @ColumnInfo(name = "percent_change_24h")
    public Double percentChange24h;

    @ColumnInfo(name = "percent_change_7d")
    public Double percentChange7d;

    @ColumnInfo(name = "market_cap")
    public Double marketCap;

    public Coin(int id, String name, String symbol, String slug, Double circulatingSupply, Double totalSupply, Double maxSupply, String dateAdded, Integer numMarketPairs, Integer cmcRank, String lastUpdated, Double price, Double volume24h, Double percentChange1h, Double percentChange24h, Double percentChange7d, Double marketCap) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.dateAdded = dateAdded;
        this.numMarketPairs = numMarketPairs;
        this.cmcRank = cmcRank;
        this.lastUpdated = lastUpdated;
        this.price = price;
        this.volume24h = volume24h;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
        this.marketCap = marketCap;
    }

    public int getId() {
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

    public Double getPrice() {
        return price;
    }

    public Double getVolume24h() {
        return volume24h;
    }

    public Double getPercentChange1h() {
        return percentChange1h;
    }

    public Double getPercentChange24h() {
        return percentChange24h;
    }

    public Double getPercentChange7d() {
        return percentChange7d;
    }

    public Double getMarketCap() {
        return marketCap;
    }
}
