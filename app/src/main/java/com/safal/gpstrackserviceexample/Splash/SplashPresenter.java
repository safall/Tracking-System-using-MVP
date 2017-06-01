package com.safal.gpstrackserviceexample.Splash;

import android.util.Log;

import com.safal.gpstrackserviceexample.Parent.ParentPresenter;
import com.safal.gpstrackserviceexample.Utils.Const;

import java.util.HashMap;

/**
 * Created by White Cat on 6/1/2017.
 */

public class SplashPresenter implements ParentPresenter<SplashMvpView> {

    private SplashMvpView mSplashMvpView;

    @Override
    public void attachView(SplashMvpView view) {
        this.mSplashMvpView = view;
    }

    @Override
    public void detachView() {
        this.mSplashMvpView = null;
    }


    void sendPost(HashMap<String, String> params) {
        if (Const.isNetworkAvailable(mSplashMvpView.getContext())) {
            mSplashMvpView.showLoading();
            Log.d("inside presenter", "here");
            mSplashMvpView.loadHome();

//            APIService mApiService = ApiUtils.getAPIService();
//            mApiService.checkUser(params).enqueue(new Callback<UserDetails>() {
//                @Override
//                public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
//                    if (response.isSuccessful()) {
//                        Log.d("success", "post submitted to API." + response.body().toString());
//
//                        mSplashMvpView.loadHome();
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<UserDetails> call, Throwable t) {
//                    Log.d("failure", t.toString());
//                    mSplashMvpView.loadHome();
//                }
//            });
        } else {
            mSplashMvpView.showNoInternetConnection();
        }


    }



}
