package com.safal.gpstrackserviceexample.Home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.safal.gpstrackserviceexample.R;
import com.safal.gpstrackserviceexample.Services.LocationUpdateService;
import com.safal.gpstrackserviceexample.Utils.Const;
import com.safal.gpstrackserviceexample.databinding.HomeBinding;


/**
 * Created by Grishma on 17/5/16.
 */
public class HomeActivity extends AppCompatActivity implements HomeMvpView {

    private boolean mIsServiceStarted = false;
    public static final String EXTRA_NOTIFICATION_ID = "notification_id";
    public static final String ACTION_STOP = "STOP_ACTION";
    public static final String ACTION_FROM_NOTIFICATION = "isFromNotification";
    //    public static final String ACTION_SNOOZE = "SNOOZE_ACTION";
//    public static final String ACTION_DISMISS = "DISMISS_ACTION";
    private String action;
    private int notifID;
    HomeBinding binding;
    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter =  new HomePresenter();
        presenter.attachView(this);
        binding = DataBindingUtil.setContentView(this, R.layout.home);

        binding.welcome.setText("Hello "+ getIntent().getStringExtra("name"));
        binding.startUpdatesButton.setOnClickListener(view ->{

            if (!mIsServiceStarted) {
                mIsServiceStarted = true;
                presenter.OnGoingLocationNotification();
                binding.startUpdatesButton.setText("STOP TRACKING");
                binding.startUpdatesButton.setBackgroundColor(getResources().getColor(R.color.standard_red));
                startService(new Intent(HomeActivity.this, LocationUpdateService.class));
            }else {
                mIsServiceStarted = false;
                binding.startUpdatesButton.setBackgroundColor(getResources().getColor(R.color.Blue));
                binding.startUpdatesButton.setText("START TRACKING");
                presenter.cancelNotification(this, notifID);
                stopService(new Intent(HomeActivity.this, LocationUpdateService.class));
            }
        });

    }


    public void exportDatabaseToSdCard(View view) {
        Const.ExportDatabase(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getAction() != null) {
            action = getIntent().getAction();
            notifID = getIntent().getIntExtra(EXTRA_NOTIFICATION_ID, 0);
            if (action.equalsIgnoreCase(ACTION_FROM_NOTIFICATION)) {
                mIsServiceStarted = true;
                binding.startUpdatesButton.setText("STOP TRACKING");
                binding.startUpdatesButton.setBackgroundColor(getResources().getColor(R.color.standard_red));

            }
        }
    }





    @Override
    public void showLoading() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showNoInternetConnection() {

    }
}
