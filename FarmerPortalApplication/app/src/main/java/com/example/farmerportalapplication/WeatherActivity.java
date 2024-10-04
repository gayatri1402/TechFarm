package com.example.farmerportalapplication;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {
    String URL = "https://api.agromonitoring.com/agro/1.0/weather?lat=19.997454&lon=73.789803&appid=ec3348e316abbaa25b52c364765068db";
    TextView txtTemp,txtHumidity,txtPressure,txtWindSpeed,txtWindDegree,txtCondDescr;
    public byte[] iconData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.weather_forecast);
        ImageView imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WeatherActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        ImageView imgLogout = findViewById(R.id.imgLogOut);
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(WeatherActivity.this)
                        .setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortalLogin", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.apply();
                                Intent i = new Intent(WeatherActivity.this, Login.class);
                                startActivity(i);
                            }
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        getWeatherData();
        txtTemp = findViewById(R.id.txtTemp);
        txtHumidity = findViewById(R.id.txtHumidity);
        txtPressure = findViewById(R.id.txtPressure);
        txtWindSpeed = findViewById(R.id.txtWindSpeed);
        txtWindDegree = findViewById(R.id.txtWindDegree);
        txtCondDescr = findViewById(R.id.txtCondDescr);
    }

    private void getWeatherData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...Please wait");
        pDialog.show();

        StringRequest jsonObjReq = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject mainObject = jsonObject.getJSONObject("main");
                            txtTemp.setText(Math.round(Float.parseFloat(mainObject.getString("temp")) - 273.15) + "\u2103");
                            txtHumidity.setText(mainObject.getString("humidity")+"%");
                            txtPressure.setText(mainObject.getString("pressure")+"hPa");

                            JSONObject windObject = jsonObject.getJSONObject("wind");
                            txtWindSpeed.setText(windObject.getString("speed")+" mps");
                            txtWindDegree.setText(windObject.getString("deg")+"\u2103");

                            JSONArray jsonArray = jsonObject.getJSONArray("weather");
                            JSONObject weatherObject = jsonArray.getJSONObject(0);
                            txtCondDescr.setText(weatherObject.getString("description"));

                            pDialog.hide();

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        pDialog.hide();
                    }
                });
        requestQueue.add(jsonObjReq);
    }}
