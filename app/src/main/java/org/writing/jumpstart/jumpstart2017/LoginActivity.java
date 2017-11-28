package org.writing.jumpstart.jumpstart2017;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.InjectView;

public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";
    private static final String URL_FOR_LOGIN = "https://XXX.XXX.X.XX/";
    ProgressDialog progressDialog;

    @InjectView(R.id.email) EditText _emailText;
    @InjectView(R.id.pass) EditText _lastNameText;
    @InjectView(R.id.login) TextView _logInButton;

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
