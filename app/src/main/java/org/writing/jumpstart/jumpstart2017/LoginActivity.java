package org.writing.jumpstart.jumpstart2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button next = (Button) findViewById(R.id.register);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent reg = new Intent(view.getContext(), RegisterActivity.class);
                startActivity(reg);
            }
        });
    }
}
