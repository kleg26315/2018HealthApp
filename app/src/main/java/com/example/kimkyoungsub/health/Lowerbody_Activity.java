package com.example.kimkyoungsub.health;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kimkyoungsub on 2018-05-27.
 */

public class Lowerbody_Activity extends AppCompatActivity {
    ListView list;
    String[] titles = {
            "바벨 스쿼트",
            "레그 프레스",
            "레그 익스텐션"

    };

    Integer[] images = {
            R.drawable.barbellsquat,
            R.drawable.legpress,
            R.drawable.legextension
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lowerbody_layout);


        CustomList adapter = new CustomList(Lowerbody_Activity.this);

        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), titles[+position], Toast.LENGTH_SHORT).show();
                if(position==0) {
                    Intent intent = new Intent(Lowerbody_Activity.this, Barbellsquart_Activity.class);
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent = new Intent(Lowerbody_Activity.this, Legpress_Activity.class);
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent = new Intent(Lowerbody_Activity.this, Legextension_Activity.class);
                    startActivity(intent);
                }

            }
        });
    }
    /*
        public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.back,menu);
            return true;
        }*/
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context){
            super(context, R.layout.all_listitem, titles);
            this.context = context;
        }

        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.all_listitem,null,true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView title = (TextView) rowView.findViewById(R.id.title);
            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            return rowView;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.realback, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.backbutton:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
