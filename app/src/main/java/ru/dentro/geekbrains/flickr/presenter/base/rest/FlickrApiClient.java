package ru.dentro.geekbrains.flickr.presenter.base.rest;

public class FlickrApiClient {

    private static final FlickrApiClient newInstance = new FlickrApiClient();

    public static FlickrApiClient getNewInstance() {
        return newInstance;
    }

    private Endpoints netApi = new ServiceGenerator().createService(Endpoints.class);

    private FlickrApiClient(){

    }


}
