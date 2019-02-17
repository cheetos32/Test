package com.hfad.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.hfad.test.Beer.beers;

public class BeerItemActivity extends AppCompatActivity {
    public TextView name,strana,krepost,cvet,description;
    public String intentString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_item);
        this.name = (TextView) findViewById(R.id.nameTextView);
        this.strana = (TextView)findViewById(R.id.stranaTextView);
        this.krepost = (TextView) findViewById(R.id.krepostTextView);
        this.cvet = (TextView) findViewById(R.id.cvetTextView);
        this.description = (TextView) findViewById(R.id.descriptionTextView);

        Intent intent = getIntent();
        intentString = intent.getStringExtra("name");

        for (Beer s : beers) {
            if ((s.getName().equals(intentString) )) {
                name.setText(s.getName());
                strana.setText(s.getStrana());
                krepost.setText(s.getKrepost());
                cvet.setText(s.getCvet());
            }
        }
    }
}
