package com.example.vyas.tictactoebypro;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class regChange extends AppCompatActivity {
    EditText name,pass,email;
    SharedPreferences base;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_change);
        name =(EditText)findViewById(R.id.editText);
        pass =(EditText)findViewById(R.id.editText3);
        email =(EditText)findViewById(R.id.editText2);
        base = PreferenceManager.getDefaultSharedPreferences(this);
        name.setText(base.getString("LastSucessfullname",""));
        pass.setText(base.getString("lastSucessfullpass",""));
        email.setText(base.getString("LastSucessfullogin",""));
    }

    public void save_details(View view) {
        String userkey = "user"+email.getText().toString();
        String usernamekey = "userName"+email.getText().toString();
        base = PreferenceManager.getDefaultSharedPreferences(this);
        editor = base.edit();
        editor.putString(userkey,pass.getText().toString());
        editor.putString(usernamekey,name.getText().toString());
        editor.remove("user"+base.getString("LastSucessfullogin",""));
        //editor.putString("lastSucessfullpass",pass.getText().toString());
        //editor.putString("LastSucessfullname",name.getText().toString());
        //editor.putString("LastSucessfullogin",email.getText().toString());
        editor.apply();
        DialogRegistered();
    }

    private void DialogRegistered() {
        String usernamekey = email.getText().toString();
        android.support.v7.app.AlertDialog.Builder loginAlert = new android.support.v7.app.AlertDialog.Builder(this);
        loginAlert.setTitle("Registratation Alert");
        loginAlert.setMessage("Details are sucessfully Updated !! \nYour new details\nNew Username : "+usernamekey+"\nNew Password : "+pass.getText().toString()+"\nNow you will be rediracted in the Loginn page to make change");
        loginAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i1 = new Intent(regChange.this,login2.class);
                startActivity(i1);
                finish();
            }
        });
        loginAlert.setCancelable(false);
        loginAlert.show();

    }
}
