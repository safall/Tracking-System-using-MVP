package com.safal.gpstrackserviceexample.App;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.safal.gpstrackserviceexample.Utils.APIService;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by White Cat on 6/1/2017.
 */

public class FleetTrackingApplication extends MultiDexApplication {

    private APIService mApiService;
    private Scheduler defaultSubscribeScheduler;

    public static FleetTrackingApplication get(Context context) {
        return (FleetTrackingApplication) context.getApplicationContext();
    }

    public APIService getApiService() {
        if (mApiService == null) {
            mApiService = APIService.Factory.create();
        }
        return mApiService;
    }

    //For setting mocks during testing
    public void setApiService(APIService apiService) {
        this.mApiService = apiService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}
