package com.example.sharedprefernceedit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class editpage extends AppCompatActivity {
    EditText username, mail, number, password;
    Button submit;
    String name,email,mobile,pass,pimage;
    public static final String MyPREFERENCES = "MyPrefs";
    private static final String TAG = editpage.class.getSimpleName();
    public static final String Name = "nameKey";
    public static final String Mail = "mailKey";
    public static final String Phone = "PhoneKey";
    public static final String Pass = "passKey";
    SharedPreferences.Editor editor= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor=sharedpreferences.edit();
        setContentView(R.layout.activity_editpage);
        username=findViewById(R.id.username);
        mail=findViewById(R.id.mail);
        number=findViewById(R.id.number);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);

        name=sharedpreferences.getString(Name,"");
        email=sharedpreferences.getString(Mail,"");
        mobile=sharedpreferences.getString(Phone,"");
        username.setText(name);
        mail.setText(email);
        number.setText(mobile);
        submit.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
        editor.putString(Name,username.getText().toString());
        editor.putString(Mail,mail.getText().toString());
        editor.putString(Phone,number.getText().toString());
        editor.apply();
        startActivity(new Intent(editpage.this,ProfileActivity.class));
        finish();
    }
});
    }
}