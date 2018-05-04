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
    private List<ExpandingType> typeList;
    private List<Video> resList;
    private List<Video> writList;
    private List<Video> revList;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videopage);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardRecycler);
        typeList = new ArrayList<>();

        videoList = new ArrayList<>();
        resList = new ArrayList<>();
        writList = new ArrayList<>();
        revList = new ArrayList<>();

//        VideoAdapter adapter = new VideoAdapter(this, videoList);
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());


        prepareVideos();
    }

    private void prepareVideos() {

        ref.child("videos").orderByChild("type").equalTo("Research").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(int i = 1; i <= dataSnapshot.getChildrenCount(); i++)
                {
                    System.out.println("in research for");
                    Video vid = dataSnapshot.child(Integer.toString(i)).getValue(Video.class);
                    resList.add(vid);
                }
                ExpandingType type = new ExpandingType("research", resList);
                typeList.add(type);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());

            }
        });

        ref.child("videos").orderByChild("type").equalTo("Writing").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(int i = 1; i <= dataSnapshot.getChildrenCount(); i++)
                {
                    System.out.println("in writing for");
                    Video vid = dataSnapshot.child(Integer.toString(i)).getValue(Video.class);
                    writList.add(vid);
                }
                ExpandingType type = new ExpandingType("writing", writList);
                typeList.add(type);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());

            }
        });

        ref.child("videos").orderByChild("type").equalTo("Revision").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(int i = 1; i <= dataSnapshot.getChildrenCount(); i++)
                {
                    System.out.println("in revision for");
                    Video vid = dataSnapshot.child(Integer.toString(i)).getValue(Video.class);
                    resList.add(vid);
                }
                ExpandingType type = new ExpandingType("revision", resList);
                typeList.add(type);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardRecycler);
        TypeAdapter adapter = new TypeAdapter(typeList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

}