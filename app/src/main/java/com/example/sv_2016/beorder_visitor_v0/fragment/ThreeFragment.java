package com.example.sv_2016.beorder_visitor_v0.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sv_2016.beorder_visitor_v0.R;

/**
 * Created by TRIPOD STUDIO on 10/22/2016.
 */

public class ThreeFragment extends BaseFragment {

    private TabLayout tabLayout;
    private LinearLayout container;


    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_notif, container, false) ;

//        tv = (TextView) v.findViewById(R.id.textview);

        return v ;
    }

//    public void setTextView(String text) {
//        tv.setText(text);
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        container = (LinearLayout) view.findViewById(R.id.fragment_container);

        tabLayout.addTab(tabLayout.newTab().setText("Struk"));
        tabLayout.addTab(tabLayout.newTab().setText("Untukmu"));

        replaceFragment(new RestoFragment());

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    replaceFragment(new StrukFragment());
                } else if (tab.getPosition() == 1) {
                    replaceFragment(new UntukmuFragment());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);

        transaction.commit();
    }
}
