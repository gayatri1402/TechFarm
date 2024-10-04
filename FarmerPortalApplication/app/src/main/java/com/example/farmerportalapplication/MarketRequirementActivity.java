package com.example.farmerportalapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MarketRequirementActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtMerchant1, txtMerchant2, txtMerchant3, txtMerchant4, txtMerchant5;
    LinearLayout ll_merchant1, ll_merchant2, ll_merchant3, ll_merchant4, ll_merchant5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketrequirement);
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.market_requirement);
        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MarketRequirementActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        ImageView imgLogout = findViewById(R.id.imgLogOut);
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MarketRequirementActivity.this)
                        .setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortalLogin", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.apply();
                                Intent i = new Intent(MarketRequirementActivity.this, Login.class);
                                startActivity(i);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        txtMerchant1 = findViewById(R.id.txtMerchant1);
        txtMerchant1.setOnClickListener(this);
        ll_merchant1 = findViewById(R.id.ll_merchant1);
        txtMerchant2 = findViewById(R.id.txtMerchant2);
        txtMerchant2.setOnClickListener(this);
        ll_merchant2 = findViewById(R.id.ll_merchant2);
        txtMerchant3 = findViewById(R.id.txtMerchant3);
        txtMerchant3.setOnClickListener(this);
        ll_merchant3 = findViewById(R.id.ll_merchant3);
        txtMerchant4 = findViewById(R.id.txtMerchant4);
        txtMerchant4.setOnClickListener(this);
        ll_merchant4 = findViewById(R.id.ll_merchant4);
        txtMerchant5 = findViewById(R.id.txtMerchant5);
        txtMerchant5.setOnClickListener(this);
        ll_merchant5 = findViewById(R.id.ll_merchant5);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtMerchant1:
                if (ll_merchant1.getVisibility() == View.VISIBLE) {
                    ll_merchant1.setVisibility(View.GONE);
                } else {
                    ll_merchant1.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtMerchant2:
                if (ll_merchant2.getVisibility() == View.VISIBLE) {
                    ll_merchant2.setVisibility(View.GONE);
                } else {
                    ll_merchant2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtMerchant3:
                if (ll_merchant3.getVisibility() == View.VISIBLE) {
                    ll_merchant3.setVisibility(View.GONE);
                } else {
                    ll_merchant3.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtMerchant4:
                if (ll_merchant4.getVisibility() == View.VISIBLE) {
                    ll_merchant4.setVisibility(View.GONE);
                } else {
                    ll_merchant4.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.txtMerchant5:
                if (ll_merchant5.getVisibility() == View.VISIBLE) {
                    ll_merchant5.setVisibility(View.GONE);
                } else {
                    ll_merchant5.setVisibility(View.VISIBLE);
                }
                break;

        }
    }
}
