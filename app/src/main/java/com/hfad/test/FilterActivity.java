package com.hfad.test;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;


public class FilterActivity extends Activity {
    public Button vivodButton;
    public Spinner cvetPiva;
    public Spinner strana;
    public Spinner krepost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
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
                    Intent intent1 = new Intent(FilterActivity.this, ActivityList.class);
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
        List<Beer> beers = BeerDB.getAllBeers();

        StringBuilder mass = new StringBuilder();

        for (Beer s : beers) {
            if ((s.cvet.equals(p1) | p1.equals("Цвет пива")) & (s.strana.equals(p2) | p2.equals("Страна")) & (s.krepost.equals(p3) | p3.equals("Крепость"))) {
                mass.append(s.name).append('\n');
            }
        }
        Intent intent = new Intent(this, ActivityList.class);
        intent.putExtra(ActivityList.LIST, mass.toString());
        startActivity(intent);


    }


}