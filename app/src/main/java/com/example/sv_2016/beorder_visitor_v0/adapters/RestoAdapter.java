package com.example.sv_2016.beorder_visitor_v0.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.models.Resto;

import java.util.List;

/**
 * Created by sv-2016 on 01/12/16.
 */
public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.MyViewHolder> {

    private List<Resto> restoList;

    public RestoAdapter(List<Resto> restoList) {
        this.restoList = restoList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView restoName,restoRegion,restoAddress,restoSeat,restoDistance;
        public ImageView restoLogo,restoBanner;

        public MyViewHolder(View itemView) {
            super(itemView);
            restoName = (TextView) itemView.findViewById(R.id.restoName);
            restoRegion = (TextView) itemView.findViewById(R.id.restoRegion);
            restoAddress = (TextView) itemView.findViewById(R.id.restoAddress);
            restoSeat = (TextView) itemView.findViewById(R.id.restoSeat);
            restoDistance = (TextView) itemView.findViewById(R.id.restoDistance);
            restoLogo = (ImageView) itemView.findViewById(R.id.restoLogo);
            restoBanner = (ImageView) itemView.findViewById(R.id.restoBanner);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resto, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Resto resto = restoList.get(position);
        holder.restoName.setText(resto.getRestoName());
        holder.restoRegion.setText(resto.getRestoRegion());
        holder.restoAddress.setText(resto.getRestoAddress());
        holder.restoSeat.setText(resto.getRestoSeat());
        holder.restoDistance.setText(resto.getRestoDistance());
        holder.restoLogo.setImageResource(resto.getRestoLogo());
        holder.restoLogo.setCropToPadding(true);
        holder.restoBanner.setImageResource(resto.getRestoBanner());
    }

    @Override
    public int getItemCount() {
        return restoList.size();
    }
}
