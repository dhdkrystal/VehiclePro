package com.xmucar.vehiclepro.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.xmucar.vehiclepro.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by lihen on 2017/4/22.
 */

public class StatusFragment extends SupportFragment {
    private TabHost tabHost;//声明TabHost组件的对象
    public static StatusFragment newInstance() {
        Bundle args = new Bundle();
        StatusFragment statusFragment = new StatusFragment();
        statusFragment.setArguments(args);
        return statusFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.status_fragment, container, false);
        tabHost = (TabHost) view.findViewById(android.R.id.tabhost);//获取tabHost对象
        tabHost.setup();//初始化TabHost组件
        inflater.inflate(R.layout.status_fragment_tab1, tabHost.getTabContentView());
        inflater.inflate(R.layout.status_fragment_tab2, tabHost.getTabContentView());
        inflater.inflate(R.layout.status_fragment_tab3, tabHost.getTabContentView());

        tabHost.addTab(tabHost.newTabSpec("tab01")
                .setIndicator("每周")
                .setContent(R.id.status_fragment_tab1));//添加第一个标签页
        tabHost.addTab(tabHost.newTabSpec("tab02")
                .setIndicator("每月")
                .setContent(R.id.status_fragment_tab2));//添加第二个标签页
        tabHost.addTab(tabHost.newTabSpec("tab03")
                .setIndicator("每年")
                .setContent(R.id.status_fragment_tab3));//添加第二个标签页
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            hideSoftInput();
        }
    }
}
