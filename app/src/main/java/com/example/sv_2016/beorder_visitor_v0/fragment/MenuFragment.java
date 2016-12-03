package com.example.sv_2016.beorder_visitor_v0.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sv_2016.beorder_visitor_v0.R;

/**
 * Created by sv-2016 on 25/11/16.
 */
public class MenuFragment extends Fragment {

    protected TextView tv ;


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_base, container, false) ;

        tv = (TextView) v.findViewById(R.id.textview);

        return v ;
    }

    public void setTextView(String text) {
        tv.setText(text);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTextView("MENU");
    }
}
