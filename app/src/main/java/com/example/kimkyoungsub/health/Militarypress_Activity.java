package com.example.kimkyoungsub.health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by kimkyoungsub on 2018-05-27.
 */

public class Militarypress_Activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.militarypress_layout);

        ImageView rabbit = (ImageView) findViewById(R.id.image1);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(rabbit);
        Glide.with(this).load(R.drawable.militarypress).into(gifImage);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.recordicon:
                Intent intent = new Intent(Militarypress_Activity.this,DetailRecord.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
