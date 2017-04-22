package com.xmucar.vehiclepro;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xmucar.vehiclepro.Fragment.MainFragment;
import com.xmucar.vehiclepro.Fragment.MarketFragment;
import com.xmucar.vehiclepro.Fragment.PersonalFragment;
import com.xmucar.vehiclepro.Fragment.StatusFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MainFragment mainFragment;
    private StatusFragment statusFragment;
    private PersonalFragment personalFragment;
    private MarketFragment marketFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        mainFragment = new MainFragment();
        statusFragment = new StatusFragment();
        marketFragment = new MarketFragment();
        personalFragment = new PersonalFragment();
        initBottomBar();
    }

    private void initBottomBar() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "主页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_status_24dp, "状态"))
                .addItem(new BottomNavigationItem(R.drawable.ic_dashboard_black_24dp, "市场"))
                .addItem(new BottomNavigationItem(R.drawable.ic_person_black_24dp, "我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor("#4d4d66")
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setFirstSelectedPosition(0)
                .initialise();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, mainFragment);
        fragmentTransaction.commit();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, mainFragment);
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, statusFragment);
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, marketFragment);
                        fragmentTransaction.commit();
                        break;
                    case 3:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, personalFragment);
                        fragmentTransaction.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {
//                switch (position) {
//                    case 0:
//                        fragmentTransaction = fragmentManager.beginTransaction();
//                        fragmentTransaction.hide(mainFragment);
//                        fragmentTransaction.commit();
//                        break;
//                    case 1:
//
//                        fragmentTransaction = fragmentManager.beginTransaction();
//                        fragmentTransaction.hide(statusFragment);
//                        fragmentTransaction.commit();
//                        break;
//                }
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }

}
