package com.nkskalyan.myapplication2.app;

import android.app.Application;

import com.nkskalyan.myapplication2.app.api.ApiModule;

import java.util.Arrays;
import java.util.List;

/**
 * Created by knachiappan on 8/9/15.
 */
public class MyApplication extends Application{

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector(){
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();
    }
    List<Object> getModules() {
        return Arrays.asList(new Object[]{new ApiModule(), new ApplicationModule(this)});
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
