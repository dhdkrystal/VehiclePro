package com.xmucar.vehiclepro.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xmucar.vehiclepro.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by lihen on 2017/4/22.
 *
 * 在onCreateView里进行一些初始化toolbar、显示加载进度条等简单UI任务，
 * 在onEnterAnimationEnd()里进行复杂UI任务
 */

public class MainFragment extends SupportFragment {

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(args);
        return mainFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
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
