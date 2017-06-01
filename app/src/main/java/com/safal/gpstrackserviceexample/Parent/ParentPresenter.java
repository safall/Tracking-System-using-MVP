package com.safal.gpstrackserviceexample.Parent;

public interface ParentPresenter<V> {

    void attachView(V view);

    void detachView();


}
