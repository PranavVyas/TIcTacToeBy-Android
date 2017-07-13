package com.example.vyas.tictactoebypro;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;

import java.io.File;

public class about_me extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }

    public void facebookClick(View view) {
        Uri fb = Uri.parse("https://www.facebook.com/pranav.vyas.330");
        Intent i1 = new Intent(Intent.ACTION_VIEW,fb);
        startActivity(i1);
    }

    public void githubClick(View view) {
        Uri github = Uri.parse("https://github.com/PranavVyas");
        Intent i2 = new Intent(Intent.ACTION_VIEW,github);
        startActivity(i2);
    }

    public void hackerearthClick(View view) {
        Uri hacker = Uri.parse("https://www.hackerearth.com/@pranavvyas4399");
        Intent i3 = new Intent(Intent.ACTION_VIEW,hacker);
        startActivity(i3);
    }

    public void blogspost(View view) {
        Uri blog = Uri.parse("http://provyas.blogspot.in");
        Intent i4 = new Intent(Intent.ACTION_VIEW,blog);
        startActivity(i4);
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

    public void instaClick(View view) {
        Uri instaUri = Uri.parse("https://www.instagram.com/pro_vyas4399");
        Intent i1 = new Intent(Intent.ACTION_VIEW,instaUri);
        startActivity(i1);
    }
}
