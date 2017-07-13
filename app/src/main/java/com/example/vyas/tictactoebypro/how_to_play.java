package com.example.vyas.tictactoebypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class how_to_play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
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

}
