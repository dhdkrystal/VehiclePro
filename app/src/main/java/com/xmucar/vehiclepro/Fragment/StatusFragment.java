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
 */

public class StatusFragment extends SupportFragment {
    public static StatusFragment newInstance() {
        Bundle args = new Bundle();
        StatusFragment statusFragment = new StatusFragment();
        statusFragment.setArguments(args);
        return statusFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.status_fragment, container, false);
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
