package com.fixello.android.app;

import android.content.Context;
import android.location.LocationManager;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by knachiappan on 8/9/15.
 */
@Module()
public class ApplicationModule {
    private MyApplication application;

    public ApplicationModule(MyApplication myApplication){
        this.application = myApplication;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
}
