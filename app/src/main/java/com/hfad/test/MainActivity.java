package com.hfad.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
    public void onClick(View view) {
        List<Beer> beer = new ArrayList<>();
        StringBuilder mass = new StringBuilder();
        //StringBuilder checkList = new StringBuilder();
        //StringBuilder vibranniyFilter = new StringBuilder();
        beer.add(new Beer("Светлое","Россия","Среднее","Жигулёвское"));
        beer.add(new Beer("Светлое","Россия","Среднее","Донская пена"));
        beer.add(new Beer("Светлое","Россия","Крепкое","Балтика 9"));
        beer.add(new Beer("Тёмное","Швеция","Среднее","Sveden Beer"));
        beer.add(new Beer("Светлое","Германия","Лёгкое","German beer"));
        beer.add(new Beer("Янтарное","Россия","Среднее","Ярпиво"));
        beer.add(new Beer("Светлое","Россия","Безалкогольное","Балтика 0"));
        beer.add(new Beer("Светлое","Россия","Лёгкое","Русское лёгкое пиво"));
        beer.add(new Beer("Светлое","Россия","Лёгкое","Классное лёгкое пиво"));

        for (Beer s: beer) {
            //String s2 = checkList.append(s).toString();
            String p1 = cvetPiva.getSelectedItem().toString();
            String p2 = strana.getSelectedItem().toString();
            String p3 = krepost.getSelectedItem().toString();
            //vibranniyFilter.append(cvetPiva.getSelectedItem()).append(strana.getSelectedItem()).append(krepost.getSelectedItem());
            if (s.cvet.equals(p1)&s.strana.equals(p2)&s.krepost.equals(p3)){
            //if (s2.startsWith(vibranniyFilter.toString())) {
                mass.append(s.name).append('\n');
            }
            //checkList = new StringBuilder();
            //vibranniyFilter = new StringBuilder();
        }
        rezultat.setText(mass);
    }
}




