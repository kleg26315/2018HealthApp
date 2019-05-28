package com.example.kimkyoungsub.health;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class DetailRecord extends AppCompatActivity implements View.OnClickListener{
    ListView mList;
    ArrayList<String> mData;
    ArrayAdapter<String> mAdap;
    String text1,text2,text3;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_record);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mList = (ListView)findViewById(R.id.listview1);
        mData = new ArrayList<String>();
        mAdap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,mData);
        mList.setAdapter(mAdap);
    }

    @Override
    public void onClick(View v) {
        final Dialog addDialog = new Dialog(this);
        addDialog.setContentView(R.layout.activity_custom_dialog);
        addDialog.setTitle("추가");

        Button delete = (Button) findViewById(R.id.delete);
        final Button check = (Button) addDialog.findViewById(R.id.check);
        Button cancel = (Button) addDialog.findViewById(R.id.cancel);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedItems = mList.getCheckedItemPositions();
                int counted;
                counted = mAdap.getCount();

                for(int i = counted -1; i>= 0; i--) {
                    if (checkedItems.get(i)) {
                        mData.remove(i);
                    }
                }
                mList.clearChoices();
                mAdap.notifyDataSetChanged();
            }
        });

        check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText set = (EditText) addDialog.findViewById(R.id.set);
                EditText kg = (EditText) addDialog.findViewById(R.id.kg);
                EditText count = (EditText) addDialog.findViewById(R.id.count);
                text1 = set.getText().toString();
                text2 = kg.getText().toString();
                text3 = count.getText().toString();
                mData.add(text1 + "세트 " + text2 + "kg " + text3 + "회");
                Toast.makeText(getApplicationContext(), "기록완료", Toast.LENGTH_LONG).show();
                addDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDialog.dismiss();
            }
        });
        addDialog.show();
    }

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        setTitle(getTime());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.timericon:
                Intent intent = new Intent(DetailRecord.this,Timer_Activity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}