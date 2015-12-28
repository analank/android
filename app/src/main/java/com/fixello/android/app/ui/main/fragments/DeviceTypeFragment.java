package com.fixello.android.app.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.fixello.android.app.R;
import com.fixello.android.app.ui.main.adapters.DeviceTypeAdapter;

/**
 * Created by knachiappan on 11/5/15.
 */
public class DeviceTypeFragment extends BaseFragment implements View.OnClickListener{

    GridView deviceGrid;
    //TODO: Set these in strings.xml
    public static String [] deviceList = {"laptop","mobile","pc","tablet"};
    public static int [] deviceImages={R.drawable.laptop,R.drawable.mobile,R.drawable.pc, R.drawable.tablet};

    public static DeviceTypeFragment newInstance() {
        DeviceTypeFragment fragment = new DeviceTypeFragment();
        return fragment;
    }

    public DeviceTypeFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View deviceChooser = inflater.inflate(R.layout.fragment_device_chooser, container, false);
        return deviceChooser;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        deviceGrid = (GridView)(getView().findViewById(R.id.device_chooser_grid));
        deviceGrid.setAdapter(new DeviceTypeAdapter(getActivity(), deviceList, deviceImages));
        mMainActivityListener.setTitle(getString(R.string.book_now));
    }

    @Override
    public void onClick(View v) {

    }
}