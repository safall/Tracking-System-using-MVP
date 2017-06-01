package com.safal.gpstrackserviceexample.Splash;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.safal.gpstrackserviceexample.Login.LoginActivity;
import com.safal.gpstrackserviceexample.R;
import com.safal.gpstrackserviceexample.databinding.SplashBinding;

import java.util.HashMap;

public class SplashActivity extends AppCompatActivity implements SplashMvpView {
    SplashBinding binding;
    Boolean noInternet = false;
    SplashPresenter presenter;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SplashPresenter();
        presenter.attachView(this);
        binding = DataBindingUtil.setContentView(this, R.layout.splash);
        onClicks();
        params.put("token", "token");
        presenter.sendPost(params);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void onClicks(){
        binding.text.setOnClickListener(v -> {
            if (noInternet) {
                params.put("token", "token");
                presenter.sendPost(params);
            }
        });
    }


    @Override
    public void showNoInternetConnection() {
        noInternet = true;
        binding.Loading.setVisibility(View.GONE);
        binding.text.setText("Internet connection is not available. \n Please connect to internet!");
    }


    @Override
    public void showLoading() {
        binding.Loading.setVisibility(View.VISIBLE);
        binding.text.setText("Checking Internet Connection...\n" +
                " Please wait!");
    }

    @Override
    public void loadHome() {
        Log.d("here", "here");
        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
