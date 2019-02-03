package com.hfad.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public Button vivodButton;
    public TextView rezultat;
    public Spinner cvetPiva;
    public Spinner strana;
    public Spinner krepost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.vivodButton = (Button) findViewById(R.id.button);
        this.rezultat = (TextView) findViewById(R.id.textView);
        this.cvetPiva = (Spinner) findViewById(R.id.spinner);
        this.strana = (Spinner) findViewById(R.id.spinner2);
        this.krepost = (Spinner) findViewById(R.id.spinner3);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.filter:
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity (intent);
                    return true;
                case R.id.catalog:
                    Intent intent1 = new Intent(MainActivity.this, ActivityList.class);
                    startActivity (intent1);
                    return true;
                case R.id.add:
                    Intent intent2 = new Intent(MainActivity.this, AddActivity.class);
                    startActivity (intent2);
                    return true;
            }
            return false;
        }
    };

    public void onClick(View view) {
        String p1 = cvetPiva.getSelectedItem().toString();
        String p2 = strana.getSelectedItem().toString();
        String p3 = krepost.getSelectedItem().toString();
        List<Beer> beer = new ArrayList<>();
        StringBuilder mass = new StringBuilder();
        beer.add(new Beer("Светлое","Россия","Среднее","Жигулёвское"));
        beer.add(new Beer("Светлое","Россия","Среднее","Донская пена"));
        beer.add(new Beer("Светлое","Россия","Крепкое","Балтика 9"));
        beer.add(new Beer("Тёмное","Швеция","Среднее","Sveden Beer"));
        beer.add(new Beer("Светлое","Германия","Лёгкое","German beer"));
        beer.add(new Beer("Янтарное","Россия","Среднее","Ярпиво"));
        beer.add(new Beer("Светлое","Россия","Безалкогольное","Балтика 0"));
        beer.add(new Beer("Светлое","Россия","Лёгкое","Русское лёгкое пиво"));
        beer.add(new Beer("Светлое","Россия","Лёгкое","Классное лёгкое пиво"));
        beer.add(new Beer("Тёмное","Россия","Лёгкое","Тёмное лёгкое пиво"));

        for (Beer s: beer) {

            if ((s.cvet.equals(p1)|p1.equals("Цвет пива"))&(s.strana.equals(p2)|p2.equals("Страна"))&(s.krepost.equals(p3)|p3.equals("Крепость"))){
                mass.append(s.name).append('\n');
            }
        }
        Intent intent = new Intent(this, ActivityList.class);
        startActivity (intent);

        rezultat.setText(mass);
    }
}