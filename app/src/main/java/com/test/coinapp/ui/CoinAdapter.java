package com.test.coinapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.test.coinapp.R;
import com.test.coinapp.room.Coin;

import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    private final List<Coin> items;
    private final OnItemClickListener listener;
    private Context context;

    public CoinAdapter(List<Coin> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.card_coin, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(items.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<Coin> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Coin coin);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView icon;
        private final TextView name, price;

        public ViewHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(final Coin coin, final OnItemClickListener listener) {
            Glide
                    .with(context)
                    .load("https://s2.coinmarketcap.com/static/img/coins/64x64/" + coin.getId() + ".png")
                    .into(icon);

            name.setText(coin.getName());
            price.setText(String.format("Price: $%s", coin.getPrice()));

            itemView.setOnClickListener(v -> listener.onItemClick(coin));
        }
    }
}