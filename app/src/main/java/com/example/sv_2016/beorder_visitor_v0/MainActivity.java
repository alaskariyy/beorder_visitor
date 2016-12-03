package com.example.sv_2016.beorder_visitor_v0;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.sv_2016.beorder_visitor_v0.fragment.FourFragment;
import com.example.sv_2016.beorder_visitor_v0.fragment.OneFragment;
import com.example.sv_2016.beorder_visitor_v0.fragment.RestoFragment;
import com.example.sv_2016.beorder_visitor_v0.fragment.ThreeFragment;
import com.example.sv_2016.beorder_visitor_v0.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public Dialog dialog;
    private FloatingActionButton fab;
    int[] tabIcons = {
            R.drawable.promo_,
            R.drawable.search_,
            R.drawable.bell_,
            R.drawable.person_
    };

    int[] tabIconsUns = {
            R.drawable.promo,
            R.drawable.search,
            R.drawable.bell,
            R.drawable.person
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()]);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsUns[tab.getPosition()]);
                    }
                });
        setupTabIcons();

        fab = (FloatingActionButton)findViewById(R.id.action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog();
            }
        });
    }

    public void CustomDialog(){

        dialog = new Dialog(MainActivity.this);
        // it remove the dialog title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the laytout in the dialog
        dialog.setContentView(R.layout.actiondialog);
        // set the background partial transparent
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        // set the layout at right bottom
        param.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        // it dismiss the dialog when click outside the dialog frame
        dialog.setCanceledOnTouchOutside(true);
        // initialize the item of the dialog box, whose id is demo1
        View demodialog =(View) dialog.findViewById(R.id.close_action_button);
        // it call when click on the item whose id is demo1.
        demodialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
            }
        });

        // it show the dialog box
        dialog.show();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIconsUns[1]);
        tabLayout.getTabAt(2).setIcon(tabIconsUns[2]);
        tabLayout.getTabAt(3).setIcon(tabIconsUns[3]);
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "ONE");
        adapter.addFrag(new RestoFragment(), "TWO");
        adapter.addFrag(new ThreeFragment(), "THREE");
        adapter.addFrag(new FourFragment(), "FOUR");
        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return null;
        }
    }
}
