package com.safal.gpstrackserviceexample.CreateAccount;

import com.safal.gpstrackserviceexample.Parent.ParentPresenter;
import com.safal.gpstrackserviceexample.Utils.Const;

import java.util.HashMap;

/**
 * Created by White Cat on 6/1/2017.
 */

public class CreateAccountPresenter implements ParentPresenter<CreateAccountMvpView> {
    CreateAccountMvpView mCreateAccountMvpView;

    @Override
    public void attachView(CreateAccountMvpView view) {
        this.mCreateAccountMvpView = view;
    }

    @Override
    public void detachView() {
        this.mCreateAccountMvpView = null;
    }

    public void CreateAccount(HashMap<String, String > params){
        if (Const.isNetworkAvailable(mCreateAccountMvpView.getContext())) {
            mCreateAccountMvpView.showLoading();
            mCreateAccountMvpView.loadHome();

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
            mCreateAccountMvpView.showNoInternetConnection();
        }


    }
}
