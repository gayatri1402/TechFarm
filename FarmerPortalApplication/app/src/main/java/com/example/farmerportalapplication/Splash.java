package com.example.farmerportalapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortalLogin",MODE_PRIVATE);
        String strEmail = sharedPreferences.getString("Email","");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (strEmail != null && !strEmail.equals("")) {
                    Intent intent = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        intent = new Intent(Splash.this, ChooseLanguage.class);
                    }
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Splash.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    }
}
