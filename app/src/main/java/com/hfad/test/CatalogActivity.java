package com.hfad.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.hfad.test.Beer.beers;

public class CatalogActivity extends FilterActivity {
    public ListView listView;
    public ArrayAdapter <String> allBeersAdapter, receivedfilterBeerListAdapter;
    public ArrayList<String> receivedfilterBeerList;
    public ArrayList<String> allBeers;
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.addMenuItem):
                Intent intent = new Intent(this,AddActivity.class);
                startActivity(intent);
                return true;
            case (R.id.filterMenuItem):
                Intent intent1 = new Intent(this,FilterActivity.class);
                startActivity(intent1);
                return true;
        }
return super.onOptionsItemSelected(item);
    }





    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.filter:
                    Intent intent = new Intent(CatalogActivity.this, FilterActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.catalog:
                    return true;
                case R.id.add:
                    Intent intent2 = new Intent(CatalogActivity.this, AddActivity.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        receivedfilterBeerList = intent.getStringArrayListExtra("filterBeerList");
        receivedfilterBeerListAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,receivedfilterBeerList);
        this.listView = (ListView) findViewById(R.id.list);
        allBeers = new ArrayList<>();
        for (Beer s: beers)
            allBeers.add(s.getName());
        allBeersAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,allBeers);
        if (receivedfilterBeerList==null)listView.setAdapter(allBeersAdapter);
        else listView.setAdapter(receivedfilterBeerListAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {

                    Intent intent = new Intent(CatalogActivity.this, BeerItemActivity.class);
                    String name = (listView.getItemAtPosition(position)).toString();
                    intent.putExtra("name",name);
                    startActivity(intent);
            }
        };
        listView.setOnItemClickListener(itemClickListener);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
    }
}
