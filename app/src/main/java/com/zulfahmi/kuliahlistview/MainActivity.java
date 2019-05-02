package com.zulfahmi.kuliahlistview;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    private String[] dataName = {"CutNyak Dien", "Ki Hajar Dewantara", "R.A. Kartini"};
    private String[] dataName;
    private String[] dataDesc;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListView listView = findViewById(R.id.lv_list);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
//        listView.setAdapter(adapter);

        HeroAdapter adapter = new HeroAdapter(this);
        prepare();
        addItem();
        adapter.setHeroes(heroes);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, heroes.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_NAME, dataName[position]);
                intent.putExtra(DetailsActivity.EXTRA_DESC, dataDesc[position]);
                intent.putExtra(DetailsActivity.EXTRA_PHOTO, dataPhoto.getResourceId(position, -1));
                startActivity(intent);
            }
        });
    }

    private void addItem(){
        heroes = new ArrayList<>();
        for(int i=0; i<dataName.length; i++){
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDesc(dataDesc[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            heroes.add(hero);
        }
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDesc = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

}

