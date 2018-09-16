package ru.dentro.geekbrains.flickr.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.dentro.geekbrains.flickr.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private boolean isContainerEmpty = true;

    public void onNameReceived(String fragmentName){
        getViewState().placeFragment(fragmentName);
        isContainerEmpty = false;
    }

    public boolean getContainerState() {
        return isContainerEmpty;
    }
}
