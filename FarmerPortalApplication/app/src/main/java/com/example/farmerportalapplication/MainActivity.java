package com.example.farmerportalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView card_7_12,cardMarketRequirement,cardMarketRate,cardWeather,cardGovSchemes,
            cardFertilizerPrediction,cardInsurance,cardContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card_7_12 = findViewById(R.id.card_7_12);
        card_7_12.setOnClickListener(this);
        cardMarketRequirement = findViewById(R.id.cardMarketRequirement);
        cardMarketRequirement.setOnClickListener(this);
        cardMarketRate = findViewById(R.id.cardMarketRate);
        cardMarketRate.setOnClickListener(this);
        cardWeather = findViewById(R.id.cardWeather);
        cardWeather.setOnClickListener(this);
        cardGovSchemes = findViewById(R.id.cardGovSchemes);
        cardGovSchemes.setOnClickListener(this);
        cardFertilizerPrediction = findViewById(R.id.cardFertilizerPrediction);
        cardFertilizerPrediction.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.card_7_12:
                i = new Intent(MainActivity.this,DocumentActivity.class);
                i.putExtra("URL","https://mahabhumi.gov.in");
                startActivity(i);
                break;
            case R.id.cardMarketRequirement:
                i = new Intent(MainActivity.this,MarketRequirementActivity.class);
                startActivity(i);
                break;
            case R.id.cardMarketRate:
                i = new Intent(MainActivity.this,DocumentActivity.class);
                i.putExtra("URL","https://rates.goldenchennai.com/vegetable-price/maharashtra-vegetableprice-today/");
                startActivity(i);
                break;
            case R.id.cardWeather:
                i = new Intent(MainActivity.this,DocumentActivity.class);
                i.putExtra("URL","https://www.accuweather.com/en/in/nashik/189304/weather-forecast/189304");
                startActivity(i);
                break;
            case R.id.cardGovSchemes:
                i = new Intent(MainActivity.this,GovSchemesActivity.class);
                startActivity(i);
                break;
            case R.id.cardFertilizerPrediction:
                i = new Intent(MainActivity.this,FertilizerActivity.class);
                startActivity(i);
                break;
        }
    }
}