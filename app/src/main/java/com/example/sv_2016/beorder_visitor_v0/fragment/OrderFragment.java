package com.example.sv_2016.beorder_visitor_v0.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.adapters.OrderAdapter;
import com.example.sv_2016.beorder_visitor_v0.adapters.PromoAdapter;
import com.example.sv_2016.beorder_visitor_v0.interfaces.RecyclerTouchListener;
import com.example.sv_2016.beorder_visitor_v0.models.Menu;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sv-2016 on 05/12/16.
 */
public class OrderFragment extends Fragment {

    private List<Menu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrderAdapter mAdapter;

    public OrderFragment(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false) ;
        return v ;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new OrderAdapter(menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        // Set padding for Tiles (not needed for Cards/Lists!)
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Menu menu = menuList.get(position);
                Toast.makeText(getActivity(), menu.getOrderHarga() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
