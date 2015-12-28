package com.fixello.android.app.ui.main.fragments;

/**
 * Created by knachiappan on 11/5/15.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fixello.android.app.R;
import com.fixello.android.app.interfaces.IMainActivityListener;
import com.fixello.android.app.ui.main.BaseActivity;
import com.fixello.android.app.ui.main.IFragmentListener;

/**
 * Created by Pedro on 15/9/2015.
 */
public class BaseFragment extends Fragment {

    protected IFragmentListener mFragmentListener;
    protected IMainActivityListener mMainActivityListener;
    protected Toolbar mToolbar;

    //TODO : Check if this is needed
    public View onCreateFragmentView(@LayoutRes int layoutId, LayoutInflater inflater, ViewGroup container, boolean withToolbar) {
        if (!withToolbar) {
            return inflater.inflate(layoutId, container, false);
        }
        View viewWithToolbar = inflater.inflate(R.layout.fragment_base, container, false);
        ViewGroup llMainContainer = (ViewGroup) viewWithToolbar.findViewById(R.id.ll_container);
        View content = inflater.inflate(layoutId, container, false);
        llMainContainer.addView(content);

        mToolbar = (Toolbar) viewWithToolbar.findViewById(R.id.toolbar);
        mFragmentListener.setToolbar(mToolbar);
        return viewWithToolbar;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragmentListener = (IFragmentListener)context;
        mMainActivityListener = (IMainActivityListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentListener = null;
        mMainActivityListener = null;
    }

    public void setTitle(String title) {
        if(getActivity() != null && getActivity() instanceof BaseActivity){
            ((BaseActivity)getActivity()).getSupportActionBar().setTitle(title);
        }
    }
}
