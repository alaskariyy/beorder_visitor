package com.example.sv_2016.beorder_visitor_v0.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sv_2016.beorder_visitor_v0.MainActivity;
import com.example.sv_2016.beorder_visitor_v0.OrderActivity;
import com.example.sv_2016.beorder_visitor_v0.R;
import com.example.sv_2016.beorder_visitor_v0.RestoProfileActivity;
import com.example.sv_2016.beorder_visitor_v0.adapters.MoviesAdapter;
import com.example.sv_2016.beorder_visitor_v0.adapters.PromoAdapter;
import com.example.sv_2016.beorder_visitor_v0.interfaces.RecyclerTouchListener;
import com.example.sv_2016.beorder_visitor_v0.models.Movie;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;
import com.example.sv_2016.beorder_visitor_v0.views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRIPOD STUDIO on 10/22/2016.
 */

public class OneFragment extends Fragment {

    protected TextView tv ;



    private List<Promo> promoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PromoAdapter mAdapter;


    public OneFragment() {
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
                Context context = view.getContext();
                Intent intent = new Intent(context, RestoProfileActivity.class);
                context.startActivity(intent);
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

//    private void loadDummyData() {
//        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Shaun the Sheep", "Animation", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
//        movieList.add(movie);
//
//        movie = new Movie("Up", "Animation", "2009");
//        movieList.add(movie);
//
//        movie = new Movie("Star Trek", "Science Fiction", "2009");
//        movieList.add(movie);
//
//        movie = new Movie("The LEGO Movie", "Animation", "2014");
//        movieList.add(movie);
//
//        movie = new Movie("Iron Man", "Action & Adventure", "2008");
//        movieList.add(movie);
//
//        movie = new Movie("Aliens", "Science Fiction", "1986");
//        movieList.add(movie);
//
//        movie = new Movie("Chicken Run", "Animation", "2000");
//        movieList.add(movie);
//
//        movie = new Movie("Back to the Future", "Science Fiction", "1985");
//        movieList.add(movie);
//
//        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
//        movieList.add(movie);
//
//        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
//        movieList.add(movie);
//
//        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
//        movieList.add(movie);
//
//        mAdapter.notifyDataSetChanged();
//    }



//    public void setTextView(String text) {
//        tv.setText(text);
//    }

}
