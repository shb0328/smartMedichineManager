package com.example.hyebeen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class SearchMedi extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private ListViewAdapter adapter;
    private String[] name;
    private ArrayList<MediData> mediDataArrayList = new ArrayList<>();

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.search_medi);

        //Create String Array
        //ex array
        name = new String[]{"tylenol","abc","tylll","tyririri","tylentr"};

        //TODO:JSON Parsor (Create name[] Array's data)

        //ListView
        listView = (ListView) findViewById(R.id.listView);

        //Set Data
        for(int i = 0;i < name.length; i++){
            MediData mediData = new MediData(name[i]);
            mediDataArrayList.add(mediData);
        }

        //The Custom adapter + ListView
        adapter = new ListViewAdapter(this,mediDataArrayList);
        listView.setAdapter(adapter);

        //EditText
        editText = (EditText) findViewById(R.id.search_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String mediName = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(mediName);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}
