package com.hfad.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
    private EditText mark;
    private Spinner cvet;
    private Spinner strana;
    private Spinner krepost;
    private Button add;
    private TextView vivod;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.filter:
                    Intent intent1 = new Intent(AddActivity.this, MainActivity.class);
                    startActivity (intent1);
                    return true;
                case R.id.catalog:
                    Intent intent2 = new Intent(AddActivity.this, ActivityList.class);
                    startActivity (intent2);
                    return true;
                case R.id.add:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.mark = (EditText) findViewById(R.id.editText4);
        this.cvet = (Spinner) findViewById(R.id.spinner4);
        this.strana = (Spinner) findViewById(R.id.spinner5);
        this.krepost = (Spinner) findViewById(R.id.spinner6);
        this.add = (Button) findViewById(R.id.button2);
        this.vivod = (TextView) findViewById(R.id.textView3);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onClick (View view) {
        StringBuilder list = new StringBuilder();
        list.append(mark.getText()).append('\n').append(cvet.getSelectedItem()).append('\n').append(strana.getSelectedItem()).append('\n').append(krepost.getSelectedItem());
        vivod.setText(list);

    }

}
