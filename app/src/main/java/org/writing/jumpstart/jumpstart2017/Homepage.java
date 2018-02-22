package org.writing.jumpstart.jumpstart2017;

import android.app.Application;
import com.google.firebase.FirebaseApp;


public class Homepage extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
