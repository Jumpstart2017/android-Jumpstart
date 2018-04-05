package org.writing.jumpstart.jumpstart2017;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends Activity {

    private List<Video> videoList;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videopage);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardRecycler);

        videoList = new ArrayList<>();
//        VideoAdapter adapter = new VideoAdapter(this, videoList);
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());


        prepareVideos();
    }

    private void prepareVideos() {

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String temp = "https://player.vimeo.com/video/";
                for(int i = 1; i <= 22; i++)
                {
                    Video vid = dataSnapshot.child("videos").child(Integer.toString(i)).getValue(Video.class);

                    vid.setURL(temp + vid.getURL().substring(18));
                    videoList.add(vid);
                }
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardRecycler);
                VideoAdapter adapter = new VideoAdapter(getBaseContext(), videoList);

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());

            }
        });
        System.out.println("video list size: " + videoList.size());
        //System.out.println("first video url" + videoList.get(1));
            //make API call to get Videos
//        for(int i = 1; i <= 22; i++){
//            String j = Integer.toString(i);
//            Video a = new Video();
//            videoList.add(a);
//        }

        //Video a = new Video("Video 1", "desc", "https://player.vimeo.com/video/114695683");
        //videoList.add(a);

        //a = new Video("Video 2", "wowoweewah!", "https://player.vimeo.com/video/114695683");
        //videoList.add(a);

//        a = new Video("Video 3", "5/5/2018", 90);
//        VideoList.add(a);
    }

}