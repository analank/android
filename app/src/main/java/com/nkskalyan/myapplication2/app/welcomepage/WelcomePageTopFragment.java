package com.nkskalyan.myapplication2.app.welcomepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by knachiappan on 10/8/15.
 */
public class WelcomePageTopFragment extends Fragment {

    final static String LAYOUT_ID = "layoutid";

    public static WelcomePageTopFragment newInstance(int layoutId) {
        WelcomePageTopFragment pane = new WelcomePageTopFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID, layoutId);
        pane.setArguments(args);
        return pane;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getArguments().getInt(LAYOUT_ID, -1), container, false);
    }

}
