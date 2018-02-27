package org.writing.jumpstart.jumpstart2017;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends Activity {

    private List<Video> videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videopage);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardRecycler);

        videoList = new ArrayList<>();
        VideoAdapter adapter = new VideoAdapter(this, videoList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        prepareVideos();
    }

    private void prepareVideos() {

        //make API call to get Videos

        Video a = new Video("Video 1", "desc", "https://player.vimeo.com/video/114695683");
        videoList.add(a);

        a = new Video("Video 2", "wowoweewah!", "https://player.vimeo.com/video/114695683");
        videoList.add(a);

//        a = new Video("Video 3", "5/5/2018", 90);
//        VideoList.add(a);
    }


}