package ru.dentro.geekbrains.flickr.model;

import android.support.annotation.Nullable;

public class FeedViewModel {
    public String imageUrl;
    public String imageDescription;

    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }

    @Nullable
    public String getImageDescription() {
        return imageDescription;
    }
}
