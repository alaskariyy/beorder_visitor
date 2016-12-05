package com.example.sv_2016.beorder_visitor_v0.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.adapters.HistoriAdaptr;
import com.example.sv_2016.beorder_visitor_v0.adapters.PromoAdapter;
import com.example.sv_2016.beorder_visitor_v0.interfaces.RecyclerTouchListener;
import com.example.sv_2016.beorder_visitor_v0.models.Histori;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRIPOD STUDIO on 10/22/2016.
 */

public class FourFragment extends BaseFragment {

    private List<Histori> historiList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HistoriAdaptr mAdapter;


    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_profile, container, false) ;

//        tv = (TextView) v.findViewById(R.id.textview);

        return v ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new HistoriAdaptr(historiList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Histori histori = historiList.get(position);
                Toast.makeText(getActivity(), histori.getRestoName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        loadDummyData();
    }

    private void loadDummyData(){
        Histori histori = new Histori("Warunk Upnormal","10/12/2016","TOTAL 210000,00",R.drawable.upnormal);
        historiList.add(histori);

        histori = new Histori("KARNIVOR","13/11/2016","TOTAL 410500,00",R.drawable.karnivorlogo);
        historiList.add(histori);

        histori = new Histori("Warunk Upnormal","10/12/2016","TOTAL 210000,00",R.drawable.upnormal);
        historiList.add(histori);

        histori = new Histori("KARNIVOR","13/11/2016","TOTAL 410500,00",R.drawable.karnivorlogo);
        historiList.add(histori);

        histori = new Histori("Warunk Upnormal","10/12/2016","TOTAL 210000,00",R.drawable.upnormal);
        historiList.add(histori);

        histori = new Histori("KARNIVOR","13/11/2016","TOTAL 410500,00",R.drawable.karnivorlogo);
        historiList.add(histori);

        histori = new Histori("Warunk Upnormal","10/12/2016","TOTAL 210000,00",R.drawable.upnormal);
        historiList.add(histori);

        histori = new Histori("KARNIVOR","13/11/2016","TOTAL 410500,00",R.drawable.karnivorlogo);
        historiList.add(histori);

        mAdapter.notifyDataSetChanged();
    }
}
