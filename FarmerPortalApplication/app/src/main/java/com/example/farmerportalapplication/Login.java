package com.example.farmerportalapplication;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    CardView btnlogin;
    TextView txtregister;
    EditText edtPass, edtEmail;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new Session(this);
        btnlogin = findViewById(R.id.btnlogin);
        txtregister = findViewById(R.id.txtregister);
        edtPass = findViewById(R.id.edtPass);
        edtEmail = findViewById(R.id.edtEmail);

        btnlogin.setOnClickListener(view -> {
            String email = edtEmail.getText().toString().trim();
            String password = edtPass.getText().toString().trim();
            String emailPattern = "[_A-Za-z0-9-.?]+@[a-z]+\\.+[a-z]+";

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(Login.this, "Please enter the email", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(Login.this, "Please input your password", Toast.LENGTH_SHORT).show();
            } else if (!email.matches(emailPattern)) {
                Toast.makeText(Login.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                Toast.makeText(Login.this, "Password Must be atleast 6 characters", Toast.LENGTH_SHORT).show();
            } else {
                login(email, password);
            }
        });
        txtregister.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });
    }

    private void login(String email, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortal",MODE_PRIVATE);
        String strEmail = sharedPreferences.getString("Email","");
        String strPassword = sharedPreferences.getString("Password","");
        String strPhone = sharedPreferences.getString("Phone","");
        if (email.equals(strEmail) && password.equals(strPassword)) {
            Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
            SharedPreferences sharedPreferences1 = getSharedPreferences("FarmerPortalLogin",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences1.edit();
            editor.putString("Email",strEmail);
            editor.putString("Password",strPassword);
            editor.putString("Phone",strPhone);
            editor.apply();
            Intent i = new Intent(getApplicationContext(),ChooseLanguage.class);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_LONG).show();
        }
    }
}
