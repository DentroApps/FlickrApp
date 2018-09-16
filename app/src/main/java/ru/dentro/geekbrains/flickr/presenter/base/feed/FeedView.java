package ru.dentro.geekbrains.flickr.presenter.base.feed;

import java.util.List;

import ru.dentro.geekbrains.flickr.model.FeedViewModel;
import ru.dentro.geekbrains.flickr.presenter.base.rest.BaseRestView;

public interface FeedView extends BaseRestView {
    void setItems(List<FeedViewModel> items);
}
