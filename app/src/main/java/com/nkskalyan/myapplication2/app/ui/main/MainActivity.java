package com.nkskalyan.myapplication2.app.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.nkskalyan.myapplication2.app.R;
import com.nkskalyan.myapplication2.app.interfaces.IMainActivityListener;
import com.nkskalyan.myapplication2.app.ui.main.fragments.BookNowFragment;
import com.nkskalyan.myapplication2.app.ui.main.fragments.CreditsFragment;
import com.nkskalyan.myapplication2.app.ui.main.fragments.FeedbackFragment;
import com.nkskalyan.myapplication2.app.ui.main.fragments.ProfileFragment;
import com.nkskalyan.myapplication2.app.ui.main.fragments.MyDevicesFragment;
import com.nkskalyan.myapplication2.app.ui.main.fragments.ReferralFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, IMainActivityListener {

    public static final String NAVIGATION_POSITION = "navigation_position";

    private NavigationView mainNavigationView;
    private DrawerLayout mainDrawerLayout;
    private TabLayout mainTabLayout;
    private Toolbar mToolbar;
    private int idSelectedNavigationItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        setUpDrawer();
        setUpToolbar();
        if ( savedInstanceState != null) {
            int menuItemId = savedInstanceState.getInt(NAVIGATION_POSITION);
            mainNavigationView.setCheckedItem(menuItemId);
            mainNavigationView.getMenu().performIdentifierAction(menuItemId, 0);
        } else {
            mainNavigationView.getMenu().performIdentifierAction(R.id.book_now, 0);
        }
    }

    private void initUI() {
        mainDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mainTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mainNavigationView = (NavigationView)findViewById(R.id.nav_view);
    }

    private void setUpDrawer() {
        mainNavigationView.setNavigationItemSelectedListener(this);
    }

    private void setUpToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //TODO: Android Image Importer followed by change symbol
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(NAVIGATION_POSITION, idSelectedNavigationItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mainDrawerLayout.closeDrawers();
        idSelectedNavigationItem = menuItem.getItemId();
        switchFragment(menuItem.getItemId());
        return false;
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void switchFragment(int menuItemId) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_content);
        switch (menuItemId) {
            case R.id.book_now:
                if (!(currentFragment instanceof BookNowFragment))
                    replaceFragment(BookNowFragment.newInstance(), false);
                break;
            case R.id.profile:
                if (!(currentFragment instanceof ProfileFragment))
                    replaceFragment(ProfileFragment.newInstance(), false);
                break;
            case R.id.my_devices:
                if (!(currentFragment instanceof MyDevicesFragment))
                    replaceFragment(MyDevicesFragment.newInstance(), false);
                break;
            case R.id.referral:
                if (!(currentFragment instanceof ReferralFragment))
                    replaceFragment(ReferralFragment.newInstance(), false);
                break;
            case R.id.credits:
                if (!(currentFragment instanceof CreditsFragment))
                    replaceFragment(CreditsFragment.newInstance(), false);
                break;
            case R.id.feedback:
                if (!(currentFragment instanceof FeedbackFragment))
                    replaceFragment(FeedbackFragment.newInstance(), false);
                break;
        }
    }
}