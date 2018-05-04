package org.writing.jumpstart.jumpstart2017;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class TypeAdapter extends ExpandableRecyclerViewAdapter<ExpandingTypeViewHolder, VideoViewHolder> {

    private LayoutInflater mInflater;
    private List<Video> videoList;

    public TypeAdapter(List<? extends ExpandableGroup> groups) {

        super(groups);
    }

    @Override
    public ExpandingTypeViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.video_list_collapsible, parent, false);
        return new ExpandingTypeViewHolder(view);
    }

    @Override
    public VideoViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.video_list, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(VideoViewHolder holder, int flatPosition, ExpandableGroup group,
                                      int childIndex) {
        final Video video = ((ExpandingType) group).getItems().get(childIndex);
        holder.vimeoVid.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = holder.vimeoVid.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(true);

        holder.vimeoVid.loadUrl(video.getURL());
        holder.title.setText(video.getTitle());
        holder.description.setText(video.getDescription());
    }

    @Override
    public void onBindGroupViewHolder(ExpandingTypeViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setType(group);
    }
}

