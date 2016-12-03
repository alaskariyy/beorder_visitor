package com.example.sv_2016.beorder_visitor_v0.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;
import com.example.sv_2016.beorder_visitor_v0.models.Struk;
import com.example.sv_2016.beorder_visitor_v0.models.Untukmu;

import java.util.List;

/**
 * Created by sv-2016 on 01/12/16.
 */
public class UntukmuAdapter extends RecyclerView.Adapter<UntukmuAdapter.MyViewHolder> {

    private List<Untukmu> untukmuList;

    public UntukmuAdapter(List<Untukmu> untukmuList) {
        this.untukmuList = untukmuList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView restoName,notifDate,notifContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            restoName = (TextView) itemView.findViewById(R.id.restoName);
            notifDate = (TextView) itemView.findViewById(R.id.notifDate);
            notifContent = (TextView) itemView.findViewById(R.id.notifContent);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_untukmu, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Untukmu untukmu = untukmuList.get(position);
        holder.restoName.setText(untukmu.getRestoName());
        holder.notifDate.setText(untukmu.getNotifDate());
        holder.notifContent.setText(untukmu.getNotifContent());
    }

    @Override
    public int getItemCount() {
        return untukmuList.size();
    }

}

