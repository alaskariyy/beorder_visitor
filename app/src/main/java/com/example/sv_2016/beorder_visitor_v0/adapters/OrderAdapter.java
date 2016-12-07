package com.example.sv_2016.beorder_visitor_v0.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sv_2016.beorder_visitor_v0.OrderActivity;
import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.models.Menu;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by sv-2016 on 05/12/16.
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private List<Menu> menuList;

    public OrderAdapter(List<Menu> menuList) {
        this.menuList = menuList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView orderHarga;
        public ImageView orderImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            orderHarga = (TextView) itemView.findViewById(R.id.orderHarga);
            orderImage = (ImageView) itemView.findViewById(R.id.orderImage);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        holder.orderHarga.setText(menu.getOrderHarga());
        holder.orderImage.setImageResource(menu.getOrderImage());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}