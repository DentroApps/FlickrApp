package ru.dentro.geekbrains.flickr.view.feed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.dentro.geekbrains.flickr.R;
import ru.dentro.geekbrains.flickr.model.FeedViewModel;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.FeedViewHolder> {

    private List<FeedViewModel> elements;
    private Context context;

    public FeedRecyclerAdapter(Context context, List<FeedViewModel> elements) {
        this.elements = elements;
        this.context = context;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.layout_feed_view, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(elements.get(position).getImageUrl())
                .into(holder.ivFeedImage);

        holder.tvDescription
                .setText(elements.get(position).getImageDescription());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivFeedImage)
        ImageView ivFeedImage;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @BindView(R.id.feed_view_layout)
        LinearLayout layout;

        public FeedViewHolder(View view) {
            super(view);
            ButterKnife.bind(view);
        }
    }

}
