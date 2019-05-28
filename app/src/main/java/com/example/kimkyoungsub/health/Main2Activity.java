package com.example.kimkyoungsub.health;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class Main2Activity extends AppCompatActivity {
    TextView nick;
    Button all,up,down,bokbu,search;
    static String name;

    protected void onDraw(Canvas canvas){
        Typeface myFont;
        myFont = Typeface.createFromAsset(this.getAssets(),"animeace2_ital.ttf");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nick = (TextView) findViewById(R.id.nickname);
        all = (Button) findViewById(R.id.allbody);
        up = (Button) findViewById(R.id.upperbody);
        down = (Button) findViewById(R.id.lowerbody);
        bokbu = (Button) findViewById(R.id.abdomen);
        search =(Button) findViewById(R.id.search_ex);
        Intent it = getIntent();
        String name = it.getStringExtra("INPUT_TEXT");
        nick.setText("Welcome " +name+"!");

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,All_Activity.class);
                startActivity(intent);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Upperbody_Activity.class);
                startActivity(intent);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Lowerbody_Activity.class);
                startActivity(intent);
            }
        });
        bokbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Abdomen_Activity.class);
                startActivity(intent);
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,Search_Activity.class);
                startActivity(intent);
            }

        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
            {
                case R.id.timericon:
                    Intent intent = new Intent(Main2Activity.this, Timer_Activity.class);
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
