package com.example.farmerportalapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ChooseLanguage extends AppCompatActivity {

    Button btncontinue;
    RadioGroup radiogroup;
    Locale myLocale;
    String selectedlang = "", currentLanguage = "en", currentLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);

        btncontinue = findViewById(R.id.btncontinue);
        radiogroup = findViewById(R.id.radiogroup);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    Toast.makeText(ChooseLanguage.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }
                if (checkedId == 1) {
                    selectedlang = "en";
                } else if (checkedId == 2) {
                    selectedlang = "mr";
                }
            }
        });
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(selectedlang)) {
                    Toast.makeText(ChooseLanguage.this, "Please select language", Toast.LENGTH_SHORT).show();
                } else {
                    setLocale(selectedlang);
                }
            }
        });

    }

    public void setLocale(String localeName) {
        myLocale = new Locale(localeName);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Language", localeName);
        startActivity(intent);
    }
}
