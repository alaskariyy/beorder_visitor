package com.example.sv_2016.beorder_visitor_v0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.sv_2016.beorder_visitor_v0.adapters.PromoAdapter;
import com.example.sv_2016.beorder_visitor_v0.interfaces.RecyclerTouchListener;
import com.example.sv_2016.beorder_visitor_v0.models.Promo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class RestoProfileActivity extends AppCompatActivity implements OnMapReadyCallback {

    private List<Promo> promoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PromoAdapter mAdapter;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
// Set title of Detail page
        collapsingToolbar.setTitle("Warunk Upnormal");
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.colorAccent));
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new PromoAdapter(promoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Promo promo = promoList.get(position);
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
