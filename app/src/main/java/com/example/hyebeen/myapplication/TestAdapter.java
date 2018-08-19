package com.example.hyebeen.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TestAdapter extends ArrayAdapter {

    Context context;
    LayoutInflater inflater;
    private List<String> list = null; //검색 후 나오는 아이템들을 담은 리스트이다.
    private ArrayList<String> arrayList; //검색 가능한 아이템들을 모두 가지고 있는다

    public TestAdapter(@NonNull Context context, int resource, @NonNull List<String> list) {
        super(context, resource, list);
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList();
        this.arrayList.addAll(list);
    }


//
//    public TestAdapter(Context context, List<String> list) {
//        this.context = context;
//        this.list = list;
//        inflater = LayoutInflater.from(context);
//        this.arrayList = new ArrayList<String>();
//        this.arrayList.addAll(list);
//
//    }

    public class ViewHolder {
        TextView label;
    }








    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        final String label = list.get(position);

        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_listview,null);
            holder.label = (TextView)convertView.findViewById(R.id.label);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.label.setText(label);

        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {                               ///BrewingActivity ?????
                Intent intent = new Intent(context,MainActivity.class);

                context.startActivity(intent);

            }
        });

        return convertView;
    }






    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        list.clear();
        if (charText.length() == 0) {
            list.addAll(arrayList);
        } else {
            for (String label : arrayList) {
                //String name = context.getResources().getString(label);       //label ?????????
                if (label.toLowerCase().contains(charText)) {
                    list.add(label);
                }
            }
        }
        notifyDataSetChanged(); //리스트뷰 갱신
    }


}
