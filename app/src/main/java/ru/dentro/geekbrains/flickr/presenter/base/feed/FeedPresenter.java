package ru.dentro.geekbrains.flickr.presenter.base.feed;

import com.arellomobile.mvp.InjectViewState;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import ru.dentro.geekbrains.flickr.model.FeedViewModel;
import ru.dentro.geekbrains.flickr.presenter.base.rest.BaseRestPresenter;

@InjectViewState
public class FeedPresenter extends BaseRestPresenter<FeedViewModel, FeedView> {

    private List<FeedViewModel> items = new ArrayList<FeedViewModel>();

    @Override
    public void onSubscribe(Subscription s) {
        super.onSubscribe(s);
    }

    @Override
    public void onNext(FeedViewModel model) {
        items.add(model);
    }

    @Override
    public void onError(Throwable t) {
        super.onError(t);
    }

    @Override
    public void onComplete() {
        getViewState().setItems(items);
    }
}
