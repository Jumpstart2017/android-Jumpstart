package org.writing.jumpstart.jumpstart2017;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<Video> videoList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public WebView vimeoVid;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.TitleText);
            description = (TextView) view.findViewById(R.id.DescText);
            vimeoVid = (WebView) view.findViewById(R.id.VideoView);
        }
    }

    public VideoAdapter(Context mContext, List<Video> VideoList) {
        mInflater = LayoutInflater.from(mContext);
        this.videoList = VideoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.video_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Video video = videoList.get(position);

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
    public int getItemCount() {
        return videoList.size();
    }
}