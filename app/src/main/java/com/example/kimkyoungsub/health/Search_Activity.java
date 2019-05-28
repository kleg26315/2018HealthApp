package com.example.kimkyoungsub.health;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Search_Activity extends AppCompatActivity {

    private List<String> list;
    private ListView listview;
    private EditText search;
    private SearchAdapter adapter;
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        search = (EditText) findViewById(R.id.search_ex);
        listview = (ListView) findViewById(R.id.listview);

        list = new ArrayList<String>();
        list.add("버피(Burpee)");
        list.add("덤벨 프론트 레이즈(Dumbbel Front Raise)");
        list.add("덤벨 레더럴 레이즈(Dumbbel Lateral Raise)");
        list.add("밴드 밀리터리 프레스(Band Military Press)");
        list.add("크런치(Crunch)");
        list.add("바벨 스쿼트(Barbell Squat)");
        list.add("레그 프레스(Leg Press)");
        list.add("레그 익스텐션(Leg Extension)");
        list.add("러시안 트위스트(Russian Twist)");
        list.add("레그 레이즈(Leg Raise)");
        list.add("하드 클린(Hard Clean)");
        list.add("암 워킹(Arm Walking)");
        list.add("푸쉬업(Push Up)");



        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        adapter = new SearchAdapter(list, this);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) list.get(position);
                switch (name){
                    case "버피(Burpee)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Search_Activity.this, Buppy_Activity.class);
                        startActivity(intent);
                        break;
                    case "덤벨 프론트 레이즈(Dumbbel Front Raise)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(Search_Activity.this, Dumbbelfrontraise_Activity.class);
                        startActivity(intent1);
                        break;
                    case "덤벨 레더럴 레이즈(Dumbbel Lateral Raise)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(Search_Activity.this, Lateralraises_Activity.class);
                        startActivity(intent2);
                        break;
                    case "밴드 밀리터리 프레스(Band Military Press)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(Search_Activity.this, Militarypress_Activity.class);
                        startActivity(intent3);
                        break;
                    case "크런치(Crunch)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(Search_Activity.this, Crunch_Activity.class);
                        startActivity(intent4);
                        break;
                    case "바벨 스쿼트(Barbell Squat)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent5 = new Intent(Search_Activity.this, Barbellsquart_Activity.class);
                        startActivity(intent5);
                        break;
                    case "레그 프레스(Leg Press)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent6 = new Intent(Search_Activity.this, Legpress_Activity.class);
                        startActivity(intent6);
                        break;
                    case "레그 익스텐션(Leg Extension)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent7 = new Intent(Search_Activity.this, Legextension_Activity.class);
                        startActivity(intent7);
                        break;

                    case "러시안 트위스트(Russian Twist)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent8 = new Intent(Search_Activity.this, Russiantwist_Activity.class);
                        startActivity(intent8);
                        break;
                    case "레그 레이즈(Leg Raise)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent9 = new Intent(Search_Activity.this, Legraise_Activity.class);
                        startActivity(intent9);
                        break;

                    case "하드 클린(Hard Clean)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent10 = new Intent(Search_Activity.this, Hardclean_Activity.class);
                        startActivity(intent10);
                        break;
                    case "암 워킹(Arm Walking)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent11 = new Intent(Search_Activity.this, Armwalking_Activity.class);
                        startActivity(intent11);
                        break;

                    case "푸쉬업(Push Up)":
                        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        Intent intent12 = new Intent(Search_Activity.this, Pushup_Activity.class);
                        startActivity(intent12);
                        break;

                    default:
                        break;
                }
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence cs, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence cs, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                String text = search.getText().toString();
                search(text);
            }
        });
    }


    public void search(String charText) {
        list.clear();
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        else
        {
            for(int i = 0;i < arraylist.size(); i++)
            {
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    list.add(arraylist.get(i));
                }
            }
        }
        adapter.notifyDataSetChanged();
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
