package ru.dentro.geekbrains.flickr.presenter.base.rest;

import com.arellomobile.mvp.MvpView;

public interface BaseRestView extends MvpView {
    void startLoading();
    void hideLoading();
    void showError(String str);
}
