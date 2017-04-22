package com.xmucar.vehiclepro;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xmucar.vehiclepro.Fragment.MainFragment;
import com.xmucar.vehiclepro.Fragment.StatusFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        fragmentManager = getFragmentManager();
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
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        MainFragment mainFragment = new MainFragment();
                        fragmentTransaction.add(R.id.main_fragment, mainFragment);
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        StatusFragment statusFragment = new StatusFragment();
                        fragmentTransaction.add(R.id.status_fragment, statusFragment);
                        fragmentTransaction.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }

}
