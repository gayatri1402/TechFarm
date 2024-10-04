package com.example.farmerportalapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class GovSchemesActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtGovScheme1, txtGovScheme2, txtGovScheme3, txtGovScheme4, txtGovScheme5, txtGovScheme6,
            txtGovScheme7, txtGovScheme8, txtGovScheme9, txtGovScheme10;
    LinearLayout ll_govScheme1, ll_govScheme2, ll_govScheme3, ll_govScheme4, ll_govScheme5, ll_govScheme6,
            ll_govScheme7, ll_govScheme8, ll_govScheme9, ll_govScheme10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govscheme);
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.government_activity);
        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GovSchemesActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        ImageView imgLogout = findViewById(R.id.imgLogOut);
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(GovSchemesActivity.this)
                        .setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortalLogin", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.apply();
                                Intent i = new Intent(GovSchemesActivity.this, Login.class);
                                startActivity(i);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        txtGovScheme1 = findViewById(R.id.txtGovScheme1);
        txtGovScheme1.setOnClickListener(this);
        ll_govScheme1 = findViewById(R.id.ll_govScheme1);
        txtGovScheme2 = findViewById(R.id.txtGovScheme2);
        txtGovScheme2.setOnClickListener(this);
        ll_govScheme2 = findViewById(R.id.ll_govScheme2);
        txtGovScheme3 = findViewById(R.id.txtGovScheme3);
        txtGovScheme3.setOnClickListener(this);
        ll_govScheme3 = findViewById(R.id.ll_govScheme3);
        txtGovScheme4 = findViewById(R.id.txtGovScheme4);
        txtGovScheme4.setOnClickListener(this);
        ll_govScheme4 = findViewById(R.id.ll_govScheme4);
        txtGovScheme5 = findViewById(R.id.txtGovScheme5);
        txtGovScheme5.setOnClickListener(this);
        ll_govScheme5 = findViewById(R.id.ll_govScheme5);
        txtGovScheme6 = findViewById(R.id.txtGovScheme6);
        txtGovScheme6.setOnClickListener(this);
        ll_govScheme6 = findViewById(R.id.ll_govScheme6);
        txtGovScheme6 = findViewById(R.id.txtGovScheme6);
        txtGovScheme6.setOnClickListener(this);
        ll_govScheme6 = findViewById(R.id.ll_govScheme6);
        txtGovScheme7 = findViewById(R.id.txtGovScheme7);
        txtGovScheme7.setOnClickListener(this);
        ll_govScheme7 = findViewById(R.id.ll_govScheme7);
        txtGovScheme8 = findViewById(R.id.txtGovScheme8);
        txtGovScheme8.setOnClickListener(this);
        ll_govScheme8 = findViewById(R.id.ll_govScheme8);
        txtGovScheme9 = findViewById(R.id.txtGovScheme9);
        txtGovScheme9.setOnClickListener(this);
        ll_govScheme9 = findViewById(R.id.ll_govScheme9);
        txtGovScheme10 = findViewById(R.id.txtGovScheme10);
        txtGovScheme10.setOnClickListener(this);
        ll_govScheme10 = findViewById(R.id.ll_govScheme10);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtGovScheme1:
                if (ll_govScheme1.getVisibility() == View.VISIBLE) {
                    ll_govScheme1.setVisibility(View.GONE);
                } else {
                    ll_govScheme1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme2:
                if (ll_govScheme2.getVisibility() == View.VISIBLE) {
                    ll_govScheme2.setVisibility(View.GONE);
                } else {
                    ll_govScheme2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme3:
                if (ll_govScheme3.getVisibility() == View.VISIBLE) {
                    ll_govScheme3.setVisibility(View.GONE);
                } else {
                    ll_govScheme3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme4:
                if (ll_govScheme4.getVisibility() == View.VISIBLE) {
                    ll_govScheme4.setVisibility(View.GONE);
                } else {
                    ll_govScheme4.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme5:
                if (ll_govScheme5.getVisibility() == View.VISIBLE) {
                    ll_govScheme5.setVisibility(View.GONE);
                } else {
                    ll_govScheme5.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme6:
                if (ll_govScheme6.getVisibility() == View.VISIBLE) {
                    ll_govScheme6.setVisibility(View.GONE);
                } else {
                    ll_govScheme6.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme7:
                if (ll_govScheme7.getVisibility() == View.VISIBLE) {
                    ll_govScheme7.setVisibility(View.GONE);
                } else {
                    ll_govScheme7.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme8:
                if (ll_govScheme8.getVisibility() == View.VISIBLE) {
                    ll_govScheme8.setVisibility(View.GONE);
                } else {
                    ll_govScheme8.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme9:
                if (ll_govScheme9.getVisibility() == View.VISIBLE) {
                    ll_govScheme9.setVisibility(View.GONE);
                } else {
                    ll_govScheme9.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtGovScheme10:
                if (ll_govScheme10.getVisibility() == View.VISIBLE) {
                    ll_govScheme10.setVisibility(View.GONE);
                } else {
                    ll_govScheme10.setVisibility(View.VISIBLE);
                }
                break;


        }
    }
}
