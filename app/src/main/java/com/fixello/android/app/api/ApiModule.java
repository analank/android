package com.fixello.android.app.api;

import com.fixello.android.app.MainThreadBus;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by knachiappan on 8/9/15.
 */
@Module()
public class ApiModule{
    @Provides
    @Singleton
    Bus provideBus(){
        return new MainThreadBus();
    }
}
