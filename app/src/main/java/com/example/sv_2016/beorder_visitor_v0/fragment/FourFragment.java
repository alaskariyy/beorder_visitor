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
import com.example.sv_2016.beorder_visitor_v0.adapters.PromoAdapter;
import com.example.sv_2016.beorder_visitor_v0.interfaces.RecyclerTouchListener;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRIPOD STUDIO on 10/22/2016.
 */

public class FourFragment extends BaseFragment {

    private List<Promo> promoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PromoAdapter mAdapter;


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

        mAdapter = new PromoAdapter(promoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Promo promo = promoList.get(position);
                Toast.makeText(getActivity(), promo.getRestoName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        loadDummyData();
    }

    private void loadDummyData(){
        Promo promo = new Promo("Warunk Upnormal","1 Hour ago","Lorem ipsum dolor sit amet," +
                "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa." +
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus " +
                "mus Lorem ipsum dolor sit amet,\" +\n" +
                "                \"consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.\" +\n" +
                "                \"Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus \" +\n" +
                "                \"mus",R.drawable.upnormal,R.drawable.upnormalpic);
        promoList.add(promo);

        promo = new Promo("KARNIVOR","1 Hour ago","Lorem ipsum dolor sit amet," +
                "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa." +
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus " +
                "mus Lorem ipsum dolor sit amet,\" +\n" +
                "                \"consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.\" +\n" +
                "                \"Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus \" +\n" +
                "                \"mus",R.drawable.karnivorlogo,R.drawable.karnivorpic);
        promoList.add(promo);

        mAdapter.notifyDataSetChanged();
    }
}
