package ru.dentro.geekbrains.flickr.presenter.base.rest;

import com.arellomobile.mvp.MvpPresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import ru.dentro.geekbrains.flickr.presenter.base.rest.BaseRestView;

public abstract class BaseRestPresenter<T, V extends BaseRestView> extends MvpPresenter<V> implements Subscriber<T> {
    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
