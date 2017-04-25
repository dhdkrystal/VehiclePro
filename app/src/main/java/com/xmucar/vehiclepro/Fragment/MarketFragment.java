package com.xmucar.vehiclepro.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xmucar.vehiclepro.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by dhd on 2017/4/23.
 */

public class MarketFragment extends SupportFragment {
    public static MarketFragment newInstance() {
        Bundle args = new Bundle();
        MarketFragment marketFragment = new MarketFragment();
        marketFragment.setArguments(args);
        return marketFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.market_fragment, container, false);
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
