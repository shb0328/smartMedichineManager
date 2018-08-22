package com.example.hyebeen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class MediInfo2 extends AppCompatActivity {

    Button btnSearch;
    Button btnReg;

    private EditText textSearch;        // 검색어를 입력할 Input 창

    private ArrayAdapter<String> adapter;
    private AutoCompleteTextView autoCompleteTextView;
    String ex[] = {"apple", "approach", "appa", "apart", "banana"};

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi2_set);

        textSearch = (EditText) findViewById(R.id.textSearch);
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.textSearch);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,ex); //JSON 파일로 받아온 약이름 배열을 연결
        autoCompleteTextView.setAdapter(adapter);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        textSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                String text = autoCompleteTextView.getText().toString();
            }
        });

    }


}

