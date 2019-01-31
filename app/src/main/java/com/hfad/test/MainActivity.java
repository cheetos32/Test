package com.hfad.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    public Button vivodButton;
    public TextView rezultat;
    public TextView proverka;
    public Spinner cvetPiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.vivodButton = (Button) findViewById(R.id.button);
        this.rezultat = (TextView) findViewById(R.id.textView);
        this.cvetPiva = (Spinner) findViewById(R.id.spinner);
        this.proverka = (TextView) findViewById(R.id.textView2);

    }




            public void onClick (View view) {
            List<Beer> beer = new ArrayList<>();
            StringBuilder mass = new StringBuilder();
            beer.add(new Beer("Ягер","Светлое",1));
            beer.add(new Beer("Балтика","Светлое",2));
            for (Beer s: beer) {
                mass.append(s).append('\n');
                rezultat.setText(mass);
                List<Beer> test = new ArrayList<>();


                // нужно сравнить выбранное значения объекта в спинере
                cvetPiva.getSelectedItem();
                        // со значением одного из атрибута объекта beer
                // как это сделать ?




                }



            }




        }




