package com.example.vyas.tictactoebypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView fptv,sptv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fptv = (EditText)findViewById(R.id.fptext);
        sptv = (EditText)findViewById(R.id.sptext);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i1 = new Intent(this,profile.class);
        switch (item.getItemId()){
            case R.id.menu_profile :
                startActivity(i1);
                break;
            case R.id.menu_aboutDev :
                Intent about_dev = new Intent(this,about_me.class);
                startActivity(about_dev);
                break;
        }
        return true;
    }

    public void Changeactivity(View view) {
        String fp = fptv.getText().toString();
        Log.i("Exectated","Got first string as "+fp);
        String sp = sptv.getText().toString();
        //Toast.makeText(this, "First Player is "+fp, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "Second Player is "+sp, Toast.LENGTH_LONG).show();
        if(fp.length() == 0 || sp.length() == 0){
            Toast.makeText(this, "Any Player's name should not be empty. Try Again", Toast.LENGTH_SHORT).show();
        }
        else if(fp.compareTo(sp) == 0) {
            Toast.makeText(this, "Both the player's name should not be equal. Try Again", Toast.LENGTH_SHORT).show();
        }else{
            Intent i1 = new Intent(this,Game.class);
            i1.putExtra("user1",fp);
            Log.i("Exectated","Puted String "+fp+" inside user1");
            i1.putExtra("user2",sp);
            Log.i("Exectated","Puted String "+sp+" inside user2");
            startActivity(i1);
        }
    }
}
