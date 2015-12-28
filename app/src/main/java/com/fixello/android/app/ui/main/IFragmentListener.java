package com.fixello.android.app.ui.main;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

/**
 * Created by knachiappan on 11/5/15.
 */
public interface IFragmentListener {
    void replaceFragment(Fragment fragment, boolean addToBackStack);
    void replaceFragment(int containerId, Fragment fragment, boolean addToBackStack);
    void setResultWithData(int status, Intent intent);
    void setToolbar(Toolbar toolbar);
    void closeActivity();
}
