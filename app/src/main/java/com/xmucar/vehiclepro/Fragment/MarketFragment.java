package com.xmucar.vehiclepro.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xmucar.vehiclepro.R;

/**
 * Created by dhd on 2017/4/23.
 */

public class MarketFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.market_fragment, container, false);
    }
}
