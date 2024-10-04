package com.example.farmerportalapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText edtxtEmail, edtxtPhone, edtxtPassword, edtxtConfirmPassword;
    Button btnRegister;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        session = new Session(this);
        edtxtEmail = findViewById(R.id.edtxtEmail);
        edtxtPhone = findViewById(R.id.edtxtPhone);
        edtxtPassword = findViewById(R.id.edtxtPassword);
        edtxtConfirmPassword = findViewById(R.id.edtxtConfirmPassword);

        btnRegister = findViewById(R.id.btnregister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = edtxtEmail.getText().toString();
                String strPhone = edtxtPhone.getText().toString();
                String strPassword = edtxtPassword.getText().toString();
                String strConfPassword = edtxtConfirmPassword.getText().toString();

                if (strPassword.equals(strConfPassword)) {
                    register(strEmail, strPassword, strPhone);
                } else {
                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void register(String strEmail, String strPassword, String strPhone) {
        SharedPreferences sharedPreferences = getSharedPreferences("FarmerPortal",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email",strEmail);
        editor.putString("Password",strPassword);
        editor.putString("Phone",strPhone);
        editor.apply();
        Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }
}
