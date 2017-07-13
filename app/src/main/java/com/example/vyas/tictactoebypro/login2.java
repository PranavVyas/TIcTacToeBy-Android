package com.example.vyas.tictactoebypro;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class login2 extends AppCompatActivity {
    EditText username,password;
    SharedPreferences base,base2;
    String unamestr = new String();
    String upassstr = new String();
    Button LOGIN;
    SharedPreferences.Editor editBase2;
    CheckBox c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        LOGIN = (Button)findViewById(R.id.button_login);
        base = PreferenceManager.getDefaultSharedPreferences(this);
        if(!base.contains("firstRun")) {
            firstrun();
            base.edit().putString("firstRun","1").apply();
        }
        username.setText(base.getString("LastLoginName",""));
        password.setText(base.getString("LastLoginPassword",""));

    }

    public void login(View view) {
        unamestr = username.getText().toString();
        base2 = PreferenceManager.getDefaultSharedPreferences(this);
        editBase2 = base2.edit();
        upassstr = password.getText().toString();
        c1 = (CheckBox)findViewById(R.id.rememberme);
        if(c1.isChecked() == true) {
            editBase2.putString("LastLoginName",unamestr);
            editBase2.putString("LastLoginPassword",upassstr);
            editBase2.putString("lastChecked","True");
            editBase2.apply();
        }else{
            editBase2.putString("LastLoginName","");
            editBase2.putString("LastLoginPassword","");
            editBase2.putString("lastChecked","false");
            editBase2.commit();
        }
        String userkey = "user"+unamestr;
        if(base2.contains(userkey) && (base2.getString(userkey,"").compareTo(upassstr) == 0 )){
            alertDialogsucess();
        }
        else {
            alertDialogfail();
            Toast.makeText(this, "Check uname or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void registermain(View view) {
        Intent i2 = new Intent(this, registre2.class);
        startActivity(i2);
        finish();
    }

    private void alertDialogsucess() {
        String usernamekey = "user"+username.getText().toString();
        AlertDialog.Builder loginAlert = new AlertDialog.Builder(this);
        loginAlert.setTitle("Login Alert");
        loginAlert.setMessage("Congratulation You have sucessfully logged in your Account \nAs : "+PreferenceManager.getDefaultSharedPreferences(this).getString(usernamekey,""));
        loginAlert.setNegativeButton("Sign in with \n different account", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        loginAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i1 = new Intent(login2.this, MainActivity.class);
                startActivity(i1);
                editBase2.putString("LastSucessfullogin",unamestr);
                editBase2.putString("lastSucessfullpass",upassstr);
                editBase2.putString("LastSucessfullname",base2.getString("userName"+unamestr,""));
                editBase2.apply();
                finish();
            }
        });
        loginAlert.setCancelable(false);
        loginAlert.show();
    }

    private void alertDialogfail() {
        String usernamekey = "user"+username.getText().toString();
        AlertDialog.Builder loginAlert = new AlertDialog.Builder(this);
        loginAlert.setTitle("Login Alert");
        loginAlert.setMessage("UserName or Password is incorrect");
        loginAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        loginAlert.show();
    }

    private void firstrun() {
        AlertDialog.Builder loginAlert = new AlertDialog.Builder(this);
        loginAlert.setTitle("What's New in this Version !!");
        loginAlert.setMessage("This Version : \nNew UI for Login!\nNew Regiatratation Portal\nMajor bug Fixes\nOnline/Offline Registratation\nDialog Ineterface and many more...");
        loginAlert.setPositiveButton("Find Out More", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse("http://provyas.blogspot.in/p/version-information.html");
                Intent igo = new Intent(Intent.ACTION_VIEW,uri);
            }
        });
        loginAlert.show();
    }
}