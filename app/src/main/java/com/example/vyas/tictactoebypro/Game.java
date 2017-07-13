package com.example.vyas.tictactoebypro;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {
    Button b11,b12,b13,b21,b22,b23,b31,b32,b33;
    TextView fptv,sptv;
    int pos[][] = new int[3][3];
    int move = 1;
    boolean draw = false;
    public String fp=new String();
    public String sp=new String();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        fptv = (TextView)findViewById(R.id.fpname);
        sptv = (TextView)findViewById(R.id.spname);
        Bundle bund1 = getIntent().getExtras();
        fp = bund1.getString("user1");
        sp = bund1.getString("user2");
        //Log.i("Exectated","Got Every thing and game activity started");
        sptv.setText(""+sp+"");
        fptv.setText(""+fp+"");
        fptv.setTextColor(this.getResources().getColor(R.color.red));
        sptv.setTextColor(this.getResources().getColor(R.color.black));
        for(int p =0;p<3;p++){
            for (int q=0;q<3;q++){
                pos[p][q] = 0;
            }
        }//Intialize Array Of Position
        Toast.makeText(this, "First Player is "+fp, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Second Player is "+sp, Toast.LENGTH_SHORT).show();
        b11 = (Button)findViewById(R.id.b11);
        b12 = (Button)findViewById(R.id.b12);
        b13 = (Button)findViewById(R.id.b13);
        b21 = (Button)findViewById(R.id.b21);
        b22 = (Button)findViewById(R.id.b22);
        b23 = (Button)findViewById(R.id.b23);
        b31 = (Button)findViewById(R.id.b31);
        b32 = (Button)findViewById(R.id.b32);
        b33 = (Button)findViewById(R.id.b33);
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

    public void disable(){
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);
        b23.setEnabled(false);
        b31.setEnabled(false);
        b32.setEnabled(false);
        b33.setEnabled(false);
    }

    public void checkWin(int pos[][]){
        for(int q=0;q<3;q++){
            if(pos[q][1]==pos[q][2]&&pos[q][2]==pos[q][0]&&pos[q][2]==1){
                alertDialogsucess(fp,1);
                disable();
                draw = false;
                break;
            }else if(pos[q][1]==pos[q][2]&&pos[q][2]==pos[q][0]&&pos[q][2]==2){
                alertDialogsucess(sp,1);
                disable();
                draw = false;
                break;
            }else if(pos[1][q]==pos[2][q]&&pos[2][q]==pos[0][q]&&pos[2][q]==1){
                alertDialogsucess(fp,1);
                disable();
                draw = false;
                break;
            }else if(pos[1][q]==pos[2][q]&&pos[2][q]==pos[0][q]&&pos[2][q]==2){
                alertDialogsucess(sp,1);
                disable();
                draw = false;
                break;
            }else if(pos[1][1]==pos[2][2]&&pos[2][2]==pos[0][0]&&pos[2][2]==1){
                alertDialogsucess(fp,1);
                disable();
                draw = false;
                break;
            }else if(pos[1][1]==pos[2][2]&&pos[2][2]==pos[0][0]&&pos[2][2]==2){
                alertDialogsucess(sp,1);
                disable();
                draw = false;
                break;
            }else if(pos[0][2]==pos[2][0]&&pos[2][0]==pos[1][1]&&pos[1][1]==1){
                alertDialogsucess(fp,1);
                disable();
                draw = false;
                break;
            }else if(pos[0][2]==pos[2][0]&&pos[2][0]==pos[1][1]&&pos[1][1]==2){
                alertDialogsucess(sp,1);
                disable();
                draw = false;
                break;
            }else{
                draw = true;
            }
        }
        if(draw == true && move == 9){
            alertDialogsucess(fp,0);
            disable();
        }
    }

    public void activeNotify() {
        if((move-1) % 2 == 0){
            sptv.setTextColor(this.getResources().getColor(R.color.red));
            fptv.setTextColor(this.getResources().getColor(R.color.black));
        }
        else{
            fptv.setTextColor(this.getResources().getColor(R.color.red));
            sptv.setTextColor(this.getResources().getColor(R.color.black));
        }
    }

    public char moveInput(int x,int y,int move,int pos[][]){
        activeNotify();
        if(move%2==1){
            pos[x][y]=1;
            System.out.println("Clicked X move = "+move+" Positition = "+x+" "+y+" Value = " +pos[x][y]);
            checkWin(pos);
            return 'X';
        }else{
            pos[x][y]=2;
            System.out.println("Clicked O move = "+move+" Positition = "+x+" "+y+" Value = " +pos[x][y]);
            checkWin(pos);
            return 'O';
        }
    }

    public void fun11(View view) {
        char pi = moveInput(0,0,move,pos);
        if(pi == 'X'){
            b11.setText(R.string.button_x);b11.setEnabled(false);
        }
        else{
            b11.setText(R.string.button_o);b11.setEnabled(false);
        }
        move++;
    }

    public void fun12(View view) {
        char pi = moveInput(0,1,move,pos);
        if(pi == 'X'){
            b12.setText(R.string.button_x);b12.setEnabled(false);
        }
        else{
            b12.setText(R.string.button_o);b12.setEnabled(false);
        }
        move++;
    }

    public void fun13(View view) {
        char pi = moveInput(0,2,move,pos);
        if(pi == 'X'){
            b13.setText(R.string.button_x);b13.setEnabled(false);
        }
        else{
            b13.setText(R.string.button_o);b13.setEnabled(false);
        }
        move++;
    }

    public void fun21(View view) {
        char pi = moveInput(1,0,move,pos);
        if(pi == 'X'){
            b21.setText(R.string.button_x);b21.setEnabled(false);
        }
        else{
            b21.setText(R.string.button_o);b21.setEnabled(false);
        }
        move++;
    }

    public void fun22(View view) {
        char pi = moveInput(1,1,move,pos);
        if(pi == 'X'){
            b22.setText(R.string.button_x);b22.setEnabled(false);
        }
        else{
            b22.setText(R.string.button_o);b22.setEnabled(false);
        }
        move++;
    }

    public void fun23(View view) {
        char pi = moveInput(1,2,move,pos);
        if(pi == 'X'){
            b23.setText(R.string.button_x);b23.setEnabled(false);
        }
        else{
            b23.setText(R.string.button_o);b23.setEnabled(false);
        }
        move++;
    }

    public void fun31(View view) {
        char pi = moveInput(2,0,move,pos);
        if(pi == 'X'){
            b31.setText(R.string.button_x);b31.setEnabled(false);
        }
        else{
            b31.setText(R.string.button_o);b31.setEnabled(false);
        }
        move++;
    }

    public void fun32(View view) {
        char pi = moveInput(2,1,move,pos);
        if(pi == 'X'){
            b32.setText(R.string.button_x);b32.setEnabled(false);
        }
        else{
            b32.setText(R.string.button_o);b32.setEnabled(false);
        }
        move++;
    }

    public void fun33(View view) {
        char pi = moveInput(2,2,move,pos);
        if(pi == 'X'){
            b33.setText(R.string.button_x);b33.setEnabled(false);
        }
        else{
            b33.setText(R.string.button_o);b33.setEnabled(false);
        }
        move++;
    }

    public void retry(View view) {
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                pos[row][column] = 0;
            }
        }//reintialize Array
        b11.setEnabled(true);b11.setText(R.string.button_name);
        b12.setEnabled(true);b12.setText(R.string.button_name);
        b13.setEnabled(true);b13.setText(R.string.button_name);
        b21.setEnabled(true);b21.setText(R.string.button_name);
        b22.setEnabled(true);b22.setText(R.string.button_name);
        b23.setEnabled(true);b23.setText(R.string.button_name);
        b31.setEnabled(true);b31.setText(R.string.button_name);
        b32.setEnabled(true);b32.setText(R.string.button_name);
        b33.setEnabled(true);b33.setText(R.string.button_name);
        move = 1;
        fptv.setTextColor(this.getResources().getColor(R.color.red));
        sptv.setTextColor(this.getResources().getColor(R.color.black));
    }

    public void how_to_play(View view) {
        Intent i1 = new Intent(this, how_to_play.class);
        startActivity(i1);
    }

    public void aboutMe(View view) {
        Intent i2 = new Intent(this, about_me.class);
        startActivity(i2);
    }

    private void alertDialogsucess(String winner,int d) {
        AlertDialog.Builder loginAlert = new AlertDialog.Builder(this);
        loginAlert.setTitle("Result");
        if(d == 0) {
            loginAlert.setMessage("No One won this Game !!\n This Game is Draw!!");
        } else {
            loginAlert.setMessage("Congratulatations !!! "+winner + " has Won this Game\n");
        }
        loginAlert.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Restart();
            }
        });
        loginAlert.setCancelable(false);
        loginAlert.show();
    }

    private void Restart() {
        for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                pos[row][column] = 0;
            }
        }//reintialize Array
        b11.setEnabled(true);b11.setText(R.string.button_name);
        b12.setEnabled(true);b12.setText(R.string.button_name);
        b13.setEnabled(true);b13.setText(R.string.button_name);
        b21.setEnabled(true);b21.setText(R.string.button_name);
        b22.setEnabled(true);b22.setText(R.string.button_name);
        b23.setEnabled(true);b23.setText(R.string.button_name);
        b31.setEnabled(true);b31.setText(R.string.button_name);
        b32.setEnabled(true);b32.setText(R.string.button_name);
        b33.setEnabled(true);b33.setText(R.string.button_name);
        move = 1;
        fptv.setTextColor(this.getResources().getColor(R.color.red));
        sptv.setTextColor(this.getResources().getColor(R.color.black));
    }

}
