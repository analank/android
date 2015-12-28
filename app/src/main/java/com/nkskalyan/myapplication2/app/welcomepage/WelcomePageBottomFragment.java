package com.nkskalyan.myapplication2.app.welcomepage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nkskalyan.myapplication2.app.R;
import com.nkskalyan.myapplication2.app.custom.CrossfadePageTransformer;
import com.nkskalyan.myapplication2.app.ui.main.MainActivity;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by knachiappan on 10/9/15.
 */
public class WelcomePageBottomFragment extends Fragment implements View.OnClickListener  {

    public static final String TAG = WelcomePageBottomFragment.class.getSimpleName();

    private static final int RC_SIGN_IN = 0;
//    private GoogleApiClient mGoogleApiClient;

    private boolean mIsResolving = false;
    private boolean mShouldResolve = false;

    private ViewPager vpWelcome;

    public static WelcomePageBottomFragment newInstance() {
        return new WelcomePageBottomFragment();
    }

    public WelcomePageBottomFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        vpWelcome = (ViewPager)rootView.findViewById(R.id.vp_welcome);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        WelcomePageTopAdapter welcomePageTopAdapter = new WelcomePageTopAdapter(getChildFragmentManager());
        vpWelcome.setAdapter(welcomePageTopAdapter);
        vpWelcome.setPageTransformer(true, new CrossfadePageTransformer());
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator)getView().findViewById(R.id.cpi_welcome);
        circlePageIndicator.setViewPager(vpWelcome);

//        getView().findViewById(R.id.sign_in_button).setOnClickListener(this);
        getView().findViewById(R.id.get_started).setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
//        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
//        mGoogleApiClient.disconnect();
    }

//    @Override
//    public void onConnected(Bundle bundle) {
//        Log.d(TAG, "onConnected:" + bundle);
//        mShouldResolve = false;
//
//        // Show the signed-in UI
//        showSignedInUI();
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.get_started) {
            showSignedInUI();
        }
    }

//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//        Log.d(TAG, "onConnectionFailed:" + connectionResult);
//        if (!mIsResolving && mShouldResolve) {
//            if (connectionResult.hasResolution()) {
//                try {
//                    connectionResult.startResolutionForResult(getActivity(), RC_SIGN_IN);
//                    mIsResolving = true;
//                } catch (IntentSender.SendIntentException e) {
//                    Log.e(TAG, "Could not resolve ConnectionResult.", e);
//                    mIsResolving = false;
//                    mGoogleApiClient.connect();
//                }
//            } else {
//                // Could not resolve the connection result, show the user an
//                // error dialog.
////                showErrorDialog(connectionResult);
//            }
//        } else {
//            // Show the signed-out UI
////            showSignedOutUI();
//        }
//    }

    private void onSignInClicked() {
        // User clicked the sign-in button, so begin the sign-in process and automatically
        // attempt to resolve any errors that occur.
        mShouldResolve = true;
//        mGoogleApiClient.connect();

        // Show a message to the user that we are signing in.
//        mStatusTextView.setText(R.string.signing_in);
    }

    private void showSignedInUI() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(getString(R.string.already_accepted_user_key), true);
        editor.apply();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().finish();
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
