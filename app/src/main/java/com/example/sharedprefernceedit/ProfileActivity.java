package com.example.sharedprefernceedit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    TextView name;
    TextView  number, address;
    String user_name;
    String E_mail;
    String Number;
    String Simage;
    Button logout,edit;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Mail = "mailKey";
    public static final String Phone = "PhoneKey";
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        address = findViewById(R.id.address);
        edit = findViewById(R.id.edit);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        E_mail = sharedpreferences.getString(Mail, "");
        Number = sharedpreferences.getString(Phone, "");
        user_name = sharedpreferences.getString(Name, "");
        name.setText(user_name);
        number.setText(Number);
        address.setText(E_mail);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ProfileActivity.this, editpage.class));
            }
        });


    }
}
