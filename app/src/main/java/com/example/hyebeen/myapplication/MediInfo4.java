package com.example.hyebeen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

public class MediInfo4 extends AppCompatActivity{

    ListView list;
    ArrayAdapter<String> Adapter1;
    ArrayAdapter<String> Adapter2;
    AutoCompleteTextView atv;
    String l[] = { "appeum", "apple", "approach", "appa", "apart", "apartment" };
    Button searchbutton;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi4_ex);


        list = (ListView) findViewById(R.id.list);
        atv = (AutoCompleteTextView) findViewById(R.id.search);
        searchbutton = (Button) findViewById(R.id.searchbutton);

        Adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, l);
        Adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, l);

        list.setAdapter(Adapter1);
        atv.setAdapter(Adapter2);
        searchbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String str = atv.getText().toString();

            }
        });


    }
}
