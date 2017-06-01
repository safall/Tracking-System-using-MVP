package com.safal.gpstrackserviceexample.Login;

import android.util.Log;

import com.safal.gpstrackserviceexample.Parent.ParentPresenter;
import com.safal.gpstrackserviceexample.Utils.Const;

import java.util.HashMap;

/**
 * Created by White Cat on 6/1/2017.
 */

public class LoginPresenter implements ParentPresenter<LoginMvpView> {
    LoginMvpView mLoginMvpView;

    @Override
    public void attachView(LoginMvpView view) {
        this.mLoginMvpView = view;
    }

    @Override
    public void detachView() {
        this.mLoginMvpView = null;
    }

    public void processLogin(HashMap<String, String> params){
        if (Const.isNetworkAvailable(mLoginMvpView.getContext())) {
            mLoginMvpView.showLoading();
            Log.d("inside presenter", "here");
            mLoginMvpView.loadHome();
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
            mLoginMvpView.showNoInternetConnection();
        }
    }




}
