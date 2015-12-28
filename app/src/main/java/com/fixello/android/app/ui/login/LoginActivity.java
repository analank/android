package com.fixello.android.app.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fixello.android.app.ApplicationComponent;
import com.fixello.android.app.MyApplication;
import com.fixello.android.app.R;
import com.fixello.android.app.models.User;
import com.fixello.android.app.ui.main.MainActivity;
import com.fixello.android.app.util.IServiceEndpoints;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends Activity{

    private int idSelectedNavigationItem;
    public final static String BASE_ENDPOINT = "http://www.mocky.io/v2";

    @Bind(R.id.input_email) EditText inputEmail;
    @Bind(R.id.input_password) EditText inputPassword;
    @Bind(R.id.login_button) Button loginButton;
//    @Bind(R.id.drawer_layout) DrawerLayout mainDrawerLayout;

    @Inject LocationManager locationManager;
    @Inject Bus mainThreadBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Called everytime orientation is changed. Use Otto MsgBus
        //TODO : Material Design for android 2.2 https://github.com/navasmdc/MaterialDesignLibrary
        //TODO: Check how to handle cases when user has already logged in
        //TODO: Use OkHttp
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //TODO: Set custom layout for title
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
        ButterKnife.bind(this);
        getApplicationComponent().inject(this);
        mainThreadBus.register(this);
    }

    @OnClick(R.id.login_button)
    void onSubmit(){
        mainThreadBus.post(new AuthenticationEvent());
    }

    @Subscribe
    public void onAuthenticate(AuthenticationEvent authenticationEvent){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_ENDPOINT).build();
        IServiceEndpoints iserviceEndpoints = restAdapter.create(IServiceEndpoints.class);
        Callback callback = new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                inputEmail.setText(user.getName());
                inputPassword.setText(user.getAge().toString());

                Toast.makeText(LoginActivity.this, user.getName().toString(), Toast.LENGTH_LONG).show();
                Intent goToNextActivity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(goToNextActivity);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("LoginActivity", error.getMessage());
                Toast.makeText(LoginActivity.this, error.getMessage() , Toast.LENGTH_LONG).show();
                Intent goToNextActivity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(goToNextActivity);
            }
        };
        iserviceEndpoints.getUsers(callback);
    }
    @Override
    protected void onResume(){
        super.onResume();
        //mainThreadBus.register(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        //mainThreadBus.unregister(this);
    }

    @Override
    protected void onStop(){
        super.onStop();
        //mainThreadBus.unregister(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mainThreadBus.unregister(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class AuthenticationEvent{
        private String userName;
    }

    public ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }
}

