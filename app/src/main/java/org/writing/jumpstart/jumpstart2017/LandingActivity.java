package org.writing.jumpstart.jumpstart2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);

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
}
