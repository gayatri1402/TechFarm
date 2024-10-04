package com.example.farmerportalapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FertilizerActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView searchView;
    TextView txtFertilizer, txtFertilizerInfo;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.fertilizer_prediction);
        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FertilizerActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        ImageView imgLogout = findViewById(R.id.imgLogOut);
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(FertilizerActivity.this)
                        .setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortalLogin", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.apply();
                                Intent i = new Intent(FertilizerActivity.this, Login.class);
                                startActivity(i);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        txtFertilizer = findViewById(R.id.txtFertilizerName);
        txtFertilizerInfo = findViewById(R.id.txtFertilizerInfo);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public boolean onQueryTextChange(String text) {
        if (text.length() == 3) {
            if (text.equals("tom")) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tomato));
                txtFertilizer.setVisibility(View.VISIBLE);
                txtFertilizerInfo.setVisibility(View.VISIBLE);
                txtFertilizer.setText(R.string.fertilizer_tomato);
                txtFertilizerInfo.setText(R.string.fertilizer_tomato_info);
            } else if (text.equals("pot")) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.potato));
                txtFertilizer.setVisibility(View.VISIBLE);
                txtFertilizerInfo.setVisibility(View.VISIBLE);
                txtFertilizer.setText(R.string.fertilizer_potato);
                txtFertilizerInfo.setText(R.string.fertilizer_potato_info);
            } else if (text.equals("ric")) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.rice));
                txtFertilizer.setVisibility(View.VISIBLE);
                txtFertilizerInfo.setVisibility(View.VISIBLE);
                txtFertilizer.setText(R.string.fertilizer_rice);
                txtFertilizerInfo.setText(R.string.fertilizer_rice_info);
            } else if (text.equals("bri")) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.brinjal));
                txtFertilizer.setVisibility(View.VISIBLE);
                txtFertilizerInfo.setVisibility(View.VISIBLE);
                txtFertilizer.setText(R.string.fertilizer_brinjal);
                txtFertilizerInfo.setText(R.string.fertilizer_brinjal_info);
            }
        } else {
            imageView.setVisibility(View.GONE);
            txtFertilizer.setVisibility(View.GONE);
            txtFertilizerInfo.setVisibility(View.GONE);
        }
        return false; }
}
