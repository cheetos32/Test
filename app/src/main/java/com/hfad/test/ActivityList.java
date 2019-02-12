package com.hfad.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ActivityList extends FilterActivity {

    public static final String LIST = "ListOfBeers";
    public ListView listView;


   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.filter:
                    Intent intent = new Intent(ActivityList.this, FilterActivity.class);
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
        this.listView = (ListView) findViewById(R.id.list);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);



    }



}
