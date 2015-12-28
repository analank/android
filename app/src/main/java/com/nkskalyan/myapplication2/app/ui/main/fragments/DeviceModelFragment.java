package com.nkskalyan.myapplication2.app.ui.main.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.nkskalyan.myapplication2.app.R;
import com.nkskalyan.myapplication2.app.ui.main.adapters.DeviceModelAdapter;
import com.nkskalyan.myapplication2.app.ui.main.adapters.DeviceTypeAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeviceModelFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeviceModelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeviceModelFragment extends BaseFragment implements View.OnClickListener {

    private GridView deviceModelGrid;
    public static String [] deviceList = {"laptop","mobile","pc","tablet"};
    public static int [] deviceImages={R.drawable.laptop,R.drawable.mobile,R.drawable.pc, R.drawable.tablet};

    public static DeviceModelFragment newInstance() {
        DeviceModelFragment fragment = new DeviceModelFragment();
        return fragment;
    }

    public DeviceModelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View deviceChooser = inflater.inflate(R.layout.fragment_device_model, container, false);
        return deviceChooser;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        deviceModelGrid = (GridView)(getView().findViewById(R.id.device_model_grid));
        deviceModelGrid.setAdapter(new DeviceModelAdapter(getActivity(),deviceList, deviceImages ));
        mMainActivityListener.setTitle(getString(R.string.book_now));
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}