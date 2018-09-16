package ru.dentro.geekbrains.flickr.view.feed;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.dentro.geekbrains.flickr.R;
import ru.dentro.geekbrains.flickr.model.FeedViewModel;
import ru.dentro.geekbrains.flickr.presenter.base.feed.FeedPresenter;
import ru.dentro.geekbrains.flickr.presenter.base.feed.FeedView;

public class FeedFragment extends Fragment implements FeedView{

    @InjectPresenter
    FeedPresenter feedPresenter;

    @BindView(R.id.feed_recycler)
    RecyclerView feedRecycler;

    private List<FeedViewModel> elements;
    private FeedRecyclerAdapter adapter;

    public FeedFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(getActivity());
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setItems(List<FeedViewModel> items) {
        adapter = new FeedRecyclerAdapter(getActivity(), items);
        feedRecycler.setAdapter(adapter);
        feedRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String str) {

    }
}
