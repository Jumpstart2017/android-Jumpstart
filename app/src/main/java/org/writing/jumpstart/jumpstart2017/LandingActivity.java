package org.writing.jumpstart.jumpstart2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LandingActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_layout_id);

        final Button SignUpButton = findViewById(R.id.button_id);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent reg = new Intent(view.getContext(), RegisterActivity.class);
                startActivity(reg);
            }
        });

        final Button TryNowButton = findViewById(R.id.button_id);
        TryNowButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent vids = new Intent(view.getContext(), VideoActivity.class);
                startActivity(vids);
            }
        });
    }

}
