package com.example.sv_2016.beorder_visitor_v0.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.adapters.RestoAdapter;
import com.example.sv_2016.beorder_visitor_v0.adapters.StrukAdapter;
import com.example.sv_2016.beorder_visitor_v0.interfaces.RecyclerTouchListener;
import com.example.sv_2016.beorder_visitor_v0.models.Resto;
import com.example.sv_2016.beorder_visitor_v0.models.Struk;
import com.example.sv_2016.beorder_visitor_v0.views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sv-2016 on 01/12/16.
 */
public class StrukFragment extends Fragment {

    private RecyclerView recyclerView;
    private StrukAdapter mAdapter;
    private List<Struk> strukList = new ArrayList<>();


    public StrukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_promo, container, false) ;

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

        mAdapter = new StrukAdapter(strukList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Struk struk = strukList.get(position);
                Toast.makeText(getActivity(), struk.getRestoName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        loadDummyData();
    }

    private void loadDummyData(){

        Struk struk = new Struk("Warunk Upnormal","10-12-2016","Rp 210000,00");
        strukList.add(struk);

        struk = new Struk("KARNIVOR","12-12-2016","Rp 570500,00");
        strukList.add(struk);

        struk = new Struk("Warunk Upnormal","10-12-2016","Rp 210000,00");
        strukList.add(struk);

        struk = new Struk("KARNIVOR","12-12-2016","Rp 570500,00");
        strukList.add(struk);

        struk = new Struk("Warunk Upnormal","10-12-2016","Rp 210000,00");
        strukList.add(struk);

        struk = new Struk("KARNIVOR","12-12-2016","Rp 570500,00");
        strukList.add(struk);

        struk = new Struk("Warunk Upnormal","10-12-2016","Rp 210000,00");
        strukList.add(struk);

        struk = new Struk("KARNIVOR","12-12-2016","Rp 570500,00");
        strukList.add(struk);

        struk = new Struk("Warunk Upnormal","10-12-2016","Rp 210000,00");
        strukList.add(struk);

        struk = new Struk("KARNIVOR","12-12-2016","Rp 570500,00");
        strukList.add(struk);

        struk = new Struk("Warunk Upnormal","10-12-2016","Rp 210000,00");
        strukList.add(struk);

        struk = new Struk("KARNIVOR","12-12-2016","Rp 570500,00");
        strukList.add(struk);

        mAdapter.notifyDataSetChanged();

    }
}
