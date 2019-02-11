package com.hfad.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ActivityList extends MainActivity {
    public TextView textView;
    public static final String LIST = "ListOfBeers";
    public MenuItem catalog;


   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.filter:
                    Intent intent = new Intent(ActivityList.this, MainActivity.class);
                    startActivity (intent);
                    return true;
                case R.id.catalog:
                    return true;
                case R.id.add:
                    Intent intent2 = new Intent(ActivityList.this, AddActivity.class);
                    startActivity (intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        this.textView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String listOfBeers = intent.getStringExtra(LIST);
        textView.setText(listOfBeers);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

    }



}
