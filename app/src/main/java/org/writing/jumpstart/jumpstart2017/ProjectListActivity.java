package org.writing.jumpstart.jumpstart2017;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class ProjectListActivity extends Activity {

    private List<Project> projectList;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        projectList = new ArrayList<>();
        ProjectAdapter adapter = new ProjectAdapter(this, projectList);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        prepareProjects();

        Button logout = (Button) findViewById(R.id.button3);
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                auth.signOut();

                // this listener will be called when there is change in firebase user session
                FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user == null) {
                            // user auth state is changed - user is null
                            // launch login activity
                            startActivity(new Intent(ProjectListActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                };
            }
        });
    }

    private void prepareProjects() {

        //make API call to get projects

        Project a = new Project("Project 1", "12/1/2018", 25);
        projectList.add(a);

        a = new Project("Project 2", "11/3/2017", 60);
        projectList.add(a);

        a = new Project("Project 3", "5/5/2018", 90);
        projectList.add(a);
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
