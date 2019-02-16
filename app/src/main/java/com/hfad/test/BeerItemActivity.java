package com.hfad.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.hfad.test.Beer.beers;

public class BeerItemActivity extends Activity {
    public TextView item,item2;
    public String intentString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_item);
        this.item = (TextView) findViewById(R.id.itemView);
        this.item2 = (TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        intentString = intent.getStringExtra("name");

        for (Beer s : beers) {
            if ((s.getName().equals(intentString) )) {
                item.setText(s.getName());
                item2.setText(s.getCvet());
            }
        }
    }
}
