package com.safal.gpstrackserviceexample.Parent;

import android.content.Context;

public interface ParentMvpView {

    Context getContext();

    void showNoInternetConnection();

    void showLoading();
}
