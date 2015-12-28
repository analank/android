package com.nkskalyan.myapplication2.app.welcomepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nkskalyan.myapplication2.app.R;

/**
 * Created by knachiappan on 10/8/15.
 */
public class WelcomePageTopAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_PAGES = 3;

    public WelcomePageTopAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        WelcomePageTopFragment tp = null;
        switch (position) {
            case 0:
                tp = WelcomePageTopFragment.newInstance(R.layout.layout_welcome_first);
                break;
            case 1:
                tp = WelcomePageTopFragment.newInstance(R.layout.layout_welcome_second);
                break;
            case 2:
                tp = WelcomePageTopFragment.newInstance(R.layout.layout_welcome_third);
                break;
        }
        return tp;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}