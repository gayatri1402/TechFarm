package com.example.farmerportalapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    String email, phone, password;
    private SharedPreferences prefs;

    public Session(Context cntx) {
        prefs = cntx.getSharedPreferences("FarmerPortal", Context.MODE_PRIVATE);
    }

    public void setEmail(String email) {
        prefs.edit().putString("email", email).apply();
    }

    public String getEmail() {
        email = prefs.getString("email", "");
        return email;
    }

    public void setPhone(String phone) {
        prefs.edit().putString("phone", phone).apply();
    }

    public String getPhone() {
        phone = prefs.getString("phone", "");
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void clear() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}
