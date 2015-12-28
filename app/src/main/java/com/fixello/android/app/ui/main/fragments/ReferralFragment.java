package com.fixello.android.app.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fixello.android.app.R;

/**
 * Created by knachiappan on 11/15/15.
 */
public class ReferralFragment extends BaseFragment implements View.OnClickListener {

    public static ReferralFragment newInstance(){
        ReferralFragment referralFragment= new ReferralFragment();
        return referralFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_referral, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mMainActivityListener.setTitle(getString(R.string.referral));
    }

    @Override
    public void onClick(View v) {

    }
}
