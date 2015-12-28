package com.fixello.android.app;

import com.fixello.android.app.ui.login.LoginActivity;
import com.fixello.android.app.api.ApiModule;

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
