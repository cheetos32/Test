package com.hfad.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.hfad.test.Beer.beers;


public class FilterActivity extends AppCompatActivity {
    public Button vivodButton;
    public Spinner cvetPiva,strana,krepost;

    public ArrayList <String> filterBeerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.vivodButton = (Button) findViewById(R.id.button);
        this.cvetPiva = (Spinner) findViewById(R.id.spinner);
        this.strana = (Spinner) findViewById(R.id.spinner2);
        this.krepost = (Spinner) findViewById(R.id.spinner3);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.filter:
                    return true;
                case R.id.catalog:
                    Intent intent1 = new Intent(FilterActivity.this, CatalogActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.add:
                    Intent intent2 = new Intent(FilterActivity.this, AddActivity.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };
    public void onClick(View view) {
        String p1 = cvetPiva.getSelectedItem().toString();
        String p2 = strana.getSelectedItem().toString();
        String p3 = krepost.getSelectedItem().toString();
        filterBeerList = new ArrayList<>();
        for (Beer s : beers) {
            if ((s.getCvet().equals(p1) | p1.equals("Цвет пива")) & (s.getStrana().equals(p2) | p2.equals("Страна")) & (s.getKrepost().equals(p3) | p3.equals("Крепость"))) {
                filterBeerList.add(s.getName());

            }
        }
        Intent intent1 = new Intent(FilterActivity.this, CatalogActivity.class);
        intent1.putStringArrayListExtra("filterBeerList",filterBeerList);

        startActivity(intent1);
    }

}
