package com.xmucar.vehiclepro;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.xmucar.vehiclepro.Fragment.MainFragment;
import com.xmucar.vehiclepro.Fragment.MarketFragment;
import com.xmucar.vehiclepro.Fragment.PersonalFragment;
import com.xmucar.vehiclepro.Fragment.StatusFragment;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.helper.FragmentLifecycleCallbacks;


public class MainActivity extends SupportActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    private MainFragment mainFragment;
    private StatusFragment statusFragment;
    private PersonalFragment personalFragment;
    private MarketFragment marketFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*设置导航栏和状态栏颜色*/
        getWindow().setNavigationBarColor(Color.parseColor("#4d4d66"));
        getWindow().setStatusBarColor(Color.parseColor("#4d4d66"));
        //设置Fragment管理器
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fragment, MainFragment.newInstance());
        }
        initFragment();
        initBottomBar();
    }

    private void initFragment() {
        popTo(MainFragment.class, false, new Runnable() {
            @Override
            public void run() {
                start(MainFragment.newInstance());
            }
        });
        registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks() {
            // 可以监听该Activity下的所有Fragment的18个生命周期方法
            @Override
            public void onFragmentCreated(SupportFragment fragment, Bundle savedInstanceState) {
                Log.i("MainActivity", "onFragmentCreated--->" + fragment.getClass().getSimpleName());
            }
        });
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
                        mainFragment = findFragment(MainFragment.class);
                        start(mainFragment, SupportFragment.SINGLETASK);
                        break;
                    case 1:
                        statusFragment = findFragment(StatusFragment.class);
                        if (statusFragment == null) {
                            popTo(MainFragment.class, false, new Runnable() {
                                @Override
                                public void run() {
                                    start(StatusFragment.newInstance());
                                }
                            });
                        } else {
                            // 如果已经在栈内,则以SingleTask模式start
                            start(statusFragment, SupportFragment.SINGLETASK);
                        }
                        break;
                    case 2:
                        marketFragment = findFragment(MarketFragment.class);
                        if (marketFragment == null) {
                            popTo(MainFragment.class, false, new Runnable() {
                                @Override
                                public void run() {
                                    start(MarketFragment.newInstance());
                                }
                            });
                        } else {
                            // 如果已经在栈内,则以SingleTask模式start
                            start(marketFragment, SupportFragment.SINGLETASK);
                        }
                        break;
                    case 3:
                        personalFragment = findFragment(PersonalFragment.class);
                        if (personalFragment == null) {
                            popTo(MainFragment.class, false, new Runnable() {
                                @Override
                                public void run() {
                                    start(PersonalFragment.newInstance());
                                }
                            });
                        } else {
                            // 如果已经在栈内,则以SingleTask模式start
                            start(personalFragment, SupportFragment.SINGLETASK);
                        }
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

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置默认Fragment动画  默认竖向(和安卓5.0以上的动画相同)
        return super.onCreateFragmentAnimator();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }
}
