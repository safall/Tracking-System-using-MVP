package com.safal.gpstrackserviceexample.CreateAccount;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.safal.gpstrackserviceexample.Home.HomeActivity;
import com.safal.gpstrackserviceexample.R;
import com.safal.gpstrackserviceexample.databinding.CreateAccountBinding;

import java.util.HashMap;

/**
 * Created by White Cat on 6/1/2017.
 */

public class CreateAccountActivity extends AppCompatActivity implements CreateAccountMvpView {
    CreateAccountPresenter presenter;
    CreateAccountBinding binding;
    HashMap<String, String> params = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CreateAccountPresenter();
        presenter.attachView(this);
        binding = DataBindingUtil.setContentView(this, R.layout.create_account);
        binding.createAccount.setOnClickListener(v -> {
            params.put("username", binding.username.getText().toString().trim());
            params.put("email", binding.email.getText().toString().trim());
            params.put("password", binding.password.getText().toString());
            presenter.CreateAccount(params);
        });
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showNoInternetConnection() {
        binding.Loading.setVisibility(View.GONE);
        binding.text.setText("No internet connection\n" +
                "Try Again");
    }

    @Override
    public void showLoading() {
        binding.Loading.setVisibility(View.VISIBLE);
        binding.text.setText("Creating your new account...\n" +
                " Please wait!");
    }

    @Override
    public void loadHome() {
        Intent i = new Intent(CreateAccountActivity.this, HomeActivity.class);
        i.putExtra("name", binding.username.getText().toString());
        startActivity(i);
        finish();
    }
}
