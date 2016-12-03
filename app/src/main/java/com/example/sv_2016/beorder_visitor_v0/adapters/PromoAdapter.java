package com.example.sv_2016.beorder_visitor_v0.adapters;

/**
 * Created by sv-2016 on 24/11/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sv_2016.beorder_visitor_v0.models.Promo;
import com.example.sv_2016.beorder_visitor_v0.R;

import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.MyViewHolder>{

    private List<Promo> promoList;

    public PromoAdapter(List<Promo> promoList) {
        this.promoList = promoList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView restoName,postTime,restoPromo;
        public ImageView restoPhoto,postPhoto;

        public MyViewHolder(View itemView) {
            super(itemView);
            restoName = (TextView) itemView.findViewById(R.id.restoName);
            restoPromo = (TextView) itemView.findViewById(R.id.restoPromo);
            postTime = (TextView) itemView.findViewById(R.id.postTime);
            restoPhoto = (ImageView) itemView.findViewById(R.id.restoPhoto);
            postPhoto = (ImageView) itemView.findViewById(R.id.postPhoto);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_promo, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Promo promo = promoList.get(position);
        holder.restoName.setText(promo.getRestoName());
        holder.restoPromo.setText(promo.getRestoPromo());
        holder.postTime.setText(promo.getPostTime());
        holder.restoPhoto.setImageResource(promo.getRestoPhoto());
        holder.postPhoto.setImageResource(promo.getPostPhoto());
    }

    @Override
    public int getItemCount() {
        return promoList.size();
    }

}
