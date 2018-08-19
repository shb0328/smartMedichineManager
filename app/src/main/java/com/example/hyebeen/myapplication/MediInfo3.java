package com.example.hyebeen.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import butterknife.BindView;

public class MediInfo3 extends AppCompatActivity {

    private TestAdapter testAdapter;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi3_test_search);


        init();

    //검색창
        textSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = textSearch.getText().toString().toLowerCase(Locale.getDefault());
                testAdapter.filter(text);
            }
        });

    }

    public void init() {

        //MediList list = new MediList(this); //MediList 구현 필요 < list 내용을 db와 연결
        List<String> list = new MediList();

        testAdapter = new TestAdapter(this, android.R.layout.simple_dropdown_item_1line,list); //어댑터에 리스트 부착
        listView.setAdapter(testAdapter); //리스트뷰에 어댑터 부착

    }

    @BindView(R.id.nameList)
    ListView listView;
    @BindView(R.id.textSearch)
    EditText textSearch;


}

class MediList implements List<String> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public String set(int index, String element) {
        return null;
    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @NonNull
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }
}