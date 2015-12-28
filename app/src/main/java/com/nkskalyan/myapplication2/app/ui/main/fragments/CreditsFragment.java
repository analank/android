package com.nkskalyan.myapplication2.app.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nkskalyan.myapplication2.app.R;

/**
 * Created by knachiappan on 11/15/15.
 */
public class CreditsFragment extends BaseFragment implements View.OnClickListener {

    public static CreditsFragment newInstance(){
        CreditsFragment creditsFragment= new CreditsFragment();
        return creditsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_credits, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mMainActivityListener.setTitle(getString(R.string.credits));
    }

    @Override
    public void onClick(View v) {

    }
}
