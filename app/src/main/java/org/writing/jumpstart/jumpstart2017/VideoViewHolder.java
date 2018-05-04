package org.writing.jumpstart.jumpstart2017;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class VideoViewHolder extends ChildViewHolder {

    public TextView title, description;
    public WebView vimeoVid;

    public VideoViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.TitleText);
        description = (TextView) view.findViewById(R.id.DescText);
        vimeoVid = (WebView) view.findViewById(R.id.VideoView);
    }

    public void onBind(Video video){
        vimeoVid.loadUrl(video.getURL());
        title.setText(video.getTitle());
        description.setText(video.getDescription());
    }
}
