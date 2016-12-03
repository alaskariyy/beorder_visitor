package com.example.sv_2016.beorder_visitor_v0.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;
import com.example.sv_2016.beorder_visitor_v0.models.Struk;

import java.util.List;

/**
 * Created by sv-2016 on 01/12/16.
 */
public class StrukAdapter extends RecyclerView.Adapter<StrukAdapter.MyViewHolder> {

    private List<Struk> strukList;

    public StrukAdapter(List<Struk> strukList) {
        this.strukList = strukList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView restoName,notifDate,strukTotal;

        public MyViewHolder(View itemView) {
            super(itemView);
            restoName = (TextView) itemView.findViewById(R.id.restoName);
            notifDate = (TextView) itemView.findViewById(R.id.notifDate);
            strukTotal = (TextView) itemView.findViewById(R.id.strukTotal);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_struk, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Struk struk = strukList.get(position);
        holder.restoName.setText(struk.getRestoName());
        holder.notifDate.setText(struk.getNotifDate());
        holder.strukTotal.setText(struk.getStrukTotal());
    }

    @Override
    public int getItemCount() {
        return strukList.size();
    }

}
