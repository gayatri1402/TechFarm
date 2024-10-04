package com.example.farmerportalapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgEmail, imgCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.contact_us);
        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContactUsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        ImageView imgLogout = findViewById(R.id.imgLogOut);
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(ContactUsActivity.this)
                        .setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortalLogin", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.apply();
                                Intent i = new Intent(ContactUsActivity.this, Login.class);
                                startActivity(i);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        imgEmail = findViewById(R.id.imgEmail);
        imgCall = findViewById(R.id.imgCall);

        imgEmail.setOnClickListener(this);
        imgCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgEmail:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.contactus_email)});
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                startActivity(Intent.createChooser(intent, ""));

                /* Create the Intent *//*
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                *//* Fill it with Data *//*
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"to@email.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");

                *//* Send it off to the Activity-Chooser *//*
                context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));*/
                break;
            case R.id.imgCall:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
             //   callIntent.setData(Uri.parse("tel:" + getString(R.string.contactus_phone)));
                callIntent.setData(Uri.parse("tel:" + "7066406475"));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
                break;
        }


    }
}
