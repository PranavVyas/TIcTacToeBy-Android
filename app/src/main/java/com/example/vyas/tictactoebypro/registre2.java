package com.example.vyas.tictactoebypro;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registre2 extends AppCompatActivity {
    EditText uname,uemail,upass,ukey;
    public SharedPreferences base;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre2);
        uname = (EditText)findViewById(R.id.nameinput);
        ukey = (EditText)findViewById(R.id.editText4);
        upass = (EditText)findViewById(R.id.passwordinput);
        uemail = (EditText)findViewById(R.id.emailinput);
        base = getSharedPreferences("userbase", Context.MODE_PRIVATE);
    }

    public void register(View view) {
        String userTestKey = ukey.getText().toString();
        String str = uemail.getText().toString();
        int encrypted[] = new int[str.length()];
        int code = 0;
        String string = "REG";
        for(int i = 0; i < str.length(); i++){
            encrypted[i] = (int)str.charAt(i);
            //console.log("Encrypted no is before"+encrypted[i]);
            encrypted[i] = ((encrypted[i] * (i+1) ) + encrypted[i]) * (i+1);
            code = code + encrypted[i];
        }
        string = string+code;
        if(userTestKey.compareTo(string) == 0) {
            String userkey = "user"+uemail.getText().toString();
            String usernamekey = "userName"+uemail.getText().toString();
            base = PreferenceManager.getDefaultSharedPreferences(this);
            editor = base.edit();
            editor.putString(userkey,upass.getText().toString());
            editor.putString(usernamekey,uname.getText().toString());
            editor.apply();
            DialogRegistered();
        } else {
            Toast.makeText(this, "Please check Your Key", Toast.LENGTH_SHORT).show();
        }
    }

    private void DialogRegistered() {
        String usernamekey = uemail.getText().toString();
        android.support.v7.app.AlertDialog.Builder loginAlert = new android.support.v7.app.AlertDialog.Builder(this);
        loginAlert.setTitle("Registratation Alert");
        loginAlert.setMessage("You Have sucessfully Registered !! \nYour details\nUsername : "+usernamekey+"\nPassword : "+upass.getText().toString());
        loginAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        loginAlert.show();
    }

    public void loginback(View view) {
        Intent i1 = new Intent(this, login2.class);
        startActivity(i1);
        finish();
    }

    public void getKey(View view) {
        Uri getkey = Uri.parse("http://provyas.blogspot.in/p/login-for-tic-tac-toe-page.html");
        Intent i2 = new Intent(Intent.ACTION_VIEW,getkey);
        startActivity(i2);
    }
}
