package com.example.vyas.tictactoebypro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    TextView name,pass,email;
    SharedPreferences base;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name =(TextView)findViewById(R.id.textView31);
        pass =(TextView)findViewById(R.id.textView33);
        email =(TextView)findViewById(R.id.textView32);
        base = PreferenceManager.getDefaultSharedPreferences(this);
        name.setText(base.getString("LastSucessfullname",""));
        pass.setText(base.getString("lastSucessfullpass",""));
        email.setText(base.getString("LastSucessfullogin",""));
    }

    public void registerAgain(View view) {
        base = PreferenceManager.getDefaultSharedPreferences(this);
        Intent i1 = new Intent(this,regChange.class);
        startActivity(i1);
    }
}
