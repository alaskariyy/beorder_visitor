package com.example.sv_2016.beorder_visitor_v0.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.sv_2016.beorder_visitor_v0.adapters.PromoAdapter;
import com.example.sv_2016.beorder_visitor_v0.adapters.RestoAdapter;
import com.example.sv_2016.beorder_visitor_v0.interfaces.RecyclerTouchListener;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;
import com.example.sv_2016.beorder_visitor_v0.models.Resto;
import com.example.sv_2016.beorder_visitor_v0.views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sv-2016 on 25/11/16.
 */
public class RestoFragment extends Fragment {

    private RecyclerView recyclerView;
    private RestoAdapter mAdapter;
    private List<Resto> restoList = new ArrayList<>();


    public RestoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_restoran, container, false) ;

//        tv = (TextView) v.findViewById(R.id.textview);

        return v ;
    }

//    public void setTextView(String text) {
//        tv.setText(text);
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setTextView("RESTO");
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new RestoAdapter(restoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

//        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
//        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Resto resto = restoList.get(position);
                Toast.makeText(getActivity(), resto.getRestoName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        loadDummyData();
    }

    private void loadDummyData(){
        Resto resto = new Resto("Warunk Upnormal", "Dipatiukur", "Jl. Dipatiukur no.666", "6 meja kosong"
                , "7km", R.drawable.upnormal, R.drawable.prm2);
        restoList.add(resto);

        resto = new Resto("Karnivor", "Riau", "Jl. riau no.666", "0 meja kosong"
                , "2km", R.drawable.karnivorlogo, R.drawable.prm3);
        restoList.add(resto);

        resto = new Resto("Warunk Upnormal", "Dipatiukur", "Jl. Dipatiukur no.666", "6 meja kosong"
                , "7km", R.drawable.upnormal, R.drawable.prm2);
        restoList.add(resto);

        resto = new Resto("Karnivor", "Riau", "Jl. riau no.666", "0 meja kosong"
                , "2km", R.drawable.karnivorlogo, R.drawable.prm3);
        restoList.add(resto);
        resto = new Resto("Warunk Upnormal", "Dipatiukur", "Jl. Dipatiukur no.666", "6 meja kosong"
                , "7km", R.drawable.upnormal, R.drawable.prm2);
        restoList.add(resto);

        resto = new Resto("Karnivor", "Riau", "Jl. riau no.666", "0 meja kosong"
                , "2km", R.drawable.karnivorlogo, R.drawable.prm3);
        restoList.add(resto);
        resto = new Resto("Warunk Upnormal", "Dipatiukur", "Jl. Dipatiukur no.666", "6 meja kosong"
                , "7km", R.drawable.upnormal, R.drawable.prm2);
        restoList.add(resto);

        resto = new Resto("Karnivor", "Riau", "Jl. riau no.666", "0 meja kosong"
                , "2km", R.drawable.karnivorlogo, R.drawable.prm3);
        restoList.add(resto);

        resto = new Resto("Warunk Upnormal", "Dipatiukur", "Jl. Dipatiukur no.666", "6 meja kosong"
                , "7km", R.drawable.upnormal, R.drawable.prm2);
        restoList.add(resto);

        resto = new Resto("Karnivor", "Riau", "Jl. riau no.666", "0 meja kosong"
                , "2km", R.drawable.karnivorlogo, R.drawable.prm3);

        restoList.add(resto);

        mAdapter.notifyDataSetChanged();
    }
}
