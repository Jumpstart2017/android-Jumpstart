package org.writing.jumpstart.jumpstart2017;

import android.support.annotation.NonNull;
import android.util.Log;

import android.app.ProgressDialog;
import android.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONObject;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import butterknife.InjectView;

public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";
    private static final String URL_FOR_LOGIN = "https://XXX.XXX.X.XX/";
    ProgressDialog progressDialog;

    private EditText _emailText;
    private EditText _passText;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, ProjectListActivity.class));
            finish();
        }

        Button next = (Button) findViewById(R.id.register);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent reg = new Intent(view.getContext(), RegisterActivity.class);
                startActivity(reg);
            }
        });

        Button login = (Button) findViewById(R.id.login);
        _emailText = (EditText) findViewById(R.id.email);
        _passText = (EditText) findViewById(R.id.pass);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String e = _emailText.getText().toString();
                String p = _passText.getText().toString();
                loginUser(e, p);
            }
        });


    }

    private void loginUser( final String email, final String password) {


        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    // If sign in fails, display a message to the user. If sign in succeeds
                    // the auth state listener will be notified and logic to handle the
                    // signed in user can be handled in the listener.
                    // progressBar.setVisibility(View.GONE);
                    if (!task.isSuccessful()) {
                        // there was an error
                        if (password.length() < 6) {
                            _passText.setError("Password too short, enter minimum 6 characters!");
                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed, check your email and password or sign up", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Intent intent = new Intent(LoginActivity.this, ProjectListActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
    }

//    private void showDialog() {
//        if (!progressDialog.isShowing())
//            progressDialog.show();
//    }
//    private void hideDialog() {
//        if (progressDialog.isShowing())
//            progressDialog.dismiss();
//    }
}
