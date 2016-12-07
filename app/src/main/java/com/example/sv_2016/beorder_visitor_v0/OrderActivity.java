package com.example.sv_2016.beorder_visitor_v0;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.sv_2016.beorder_visitor_v0.fragment.OneFragment;
import com.example.sv_2016.beorder_visitor_v0.fragment.OrderFragment;
import com.example.sv_2016.beorder_visitor_v0.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private List<Menu> menuList1 = new ArrayList<>();
    private List<Menu> menuList2 = new ArrayList<>();
    private List<Menu> menuList3 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        loadDummyData();
    }

    private void loadDummyData(){
        Menu menu = new Menu("Rp 20000,00",R.drawable.karnivorlogo);
        menuList1.add(menu);

        menu = new Menu("Rp 3000,00",R.drawable.add);
        menuList1.add(menu);

        menu = new Menu("Rp 20000,00",R.drawable.karnivorlogo);
        menuList1.add(menu);

        menu = new Menu("Rp 3000,00",R.drawable.add);
        menuList1.add(menu);

        menu = new Menu("Rp 20000,00",R.drawable.karnivorlogo);
        menuList1.add(menu);

        menu = new Menu("Rp 3000,00",R.drawable.add);
        menuList1.add(menu);

        menu = new Menu("Rp 20000,00",R.drawable.bell_);
        menuList2.add(menu);

        menu = new Menu("Rp 3000,00",R.drawable.beorder_logo_shadow_square);
        menuList2.add(menu);

        menu = new Menu("Rp 20000,00",R.drawable.bell_);
        menuList3.add(menu);

        menu = new Menu("Rp 3000,00",R.drawable.beorder_logo_shadow_square);
        menuList3.add(menu);

        adapter.notifyDataSetChanged();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OrderFragment(menuList1), "Makanan");
        adapter.addFrag(new OrderFragment(menuList2), "Minuman");
        adapter.addFrag(new OrderFragment(menuList3), "Cemilan");
        adapter.addFrag(new OrderFragment(menuList1), "Cuci mulut");
        adapter.addFrag(new OrderFragment(menuList2), "Iseng");
        adapter.addFrag(new OrderFragment(menuList3), "Kopi");

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
            return mFragmentTitleList.get(position);
        }
    }
}
