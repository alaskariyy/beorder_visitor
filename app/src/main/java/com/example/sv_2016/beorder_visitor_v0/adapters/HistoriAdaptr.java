package com.example.sv_2016.beorder_visitor_v0.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.models.Histori;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;

import java.util.List;

/**
 * Created by sv-2016 on 03/12/16.
 */
public class HistoriAdaptr extends RecyclerView.Adapter<HistoriAdaptr.MyViewHolder>{

    private List<Histori> historiList;

    public HistoriAdaptr(List<Histori> historiList) {
        this.historiList = historiList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView restoName,historiDate,historiTotal;
        public ImageView restoPhoto;

        public MyViewHolder(View itemView) {
            super(itemView);
            restoName = (TextView) itemView.findViewById(R.id.restoName);
            historiDate = (TextView) itemView.findViewById(R.id.historiTime);
            historiTotal = (TextView) itemView.findViewById(R.id.historiTotal);
            restoPhoto = (ImageView) itemView.findViewById(R.id.restoPhoto);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Histori histori = historiList.get(position);
        holder.restoName.setText(histori.getRestoName());
        holder.historiDate.setText(histori.getHistoriDate());
        holder.historiTotal.setText(histori.getHistoriTotal());
        holder.restoPhoto.setImageResource(histori.getRestoPhoto());
    }

    @Override
    public int getItemCount() {
        return historiList.size();
    }

}
