package org.writing.jumpstart.jumpstart2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandingActivity extends Activity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

        mAuth = FirebaseAuth.getInstance();

        Button next = (Button) findViewById(R.id.SignUpButton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent login = new Intent(view.getContext(), LoginActivity.class);
                startActivity(login);
            }
        });

        Button trynow = (Button) findViewById(R.id.TryNowButton);
        trynow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent trying = new Intent(view.getContext(), ProjectListActivity.class);
                Intent trying = new Intent(view.getContext(), VideoActivity.class);
                startActivity(trying);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent projectList = new Intent(this, ProjectListActivity.class);
            startActivity(projectList);
            finish();
        }
    }
}
