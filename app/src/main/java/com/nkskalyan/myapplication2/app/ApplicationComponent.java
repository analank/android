package com.nkskalyan.myapplication2.app;

import com.nkskalyan.myapplication2.app.ui.login.LoginActivity;
import com.nkskalyan.myapplication2.app.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by knachiappan on 8/16/15.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity activity);
}
