package com.xmucar.vehiclepro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
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
                        mTextMessage.setText("主页");
                        break;
                    case 1:
                        mTextMessage.setText("状态");
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
