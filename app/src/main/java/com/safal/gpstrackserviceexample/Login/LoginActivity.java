package com.safal.gpstrackserviceexample.Login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.safal.gpstrackserviceexample.CreateAccount.CreateAccountActivity;
import com.safal.gpstrackserviceexample.Home.HomeActivity;
import com.safal.gpstrackserviceexample.R;
import com.safal.gpstrackserviceexample.databinding.LoginBinding;

import java.util.HashMap;

/**
 * Created by White Cat on 6/1/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginMvpView {
    LoginPresenter presenter;
    LoginBinding binding;
    HashMap<String, String> params = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter();
        presenter.attachView(this);
        binding = DataBindingUtil.setContentView(this, R.layout.login);
        onClicks();
    }

    private void onClicks(){
        binding.loginButton.setOnClickListener(v->{
            params.put("userName", binding.username.getText().toString().trim());
            params.put("password", binding.password.getText().toString());
            presenter.processLogin(params);
        });
        binding.createAccount.setOnClickListener(v->{
            Intent i = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(i);
            finish();
        });
        binding.text.setOnClickListener(v->{
            params.put("userName", binding.username.getText().toString().trim());
            params.put("password", binding.password.getText().toString());
            presenter.processLogin(params);
        });

    }


    @Override
    public void showLoading() {
        binding.loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showNoInternetConnection() {
        binding.loadingView.setVisibility(View.GONE);
        binding.text.setText("No internet connection. Please try again!");
    }

    @Override
    public void loadHome() {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        i.putExtra("name", binding.username.getText().toString());
        startActivity(i);
        finish();
    }
}
