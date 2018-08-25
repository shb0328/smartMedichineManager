package com.example.hyebeen.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<MediData> mediDataList;
    ArrayList<MediData> mediDataArray;

    public ListViewAdapter(Context context, List<MediData> mediDataList) {
        this.context = context;
        this.mediDataList = mediDataList;
        inflater = LayoutInflater.from(this.context);
        mediDataArray = new ArrayList<MediData>();
        mediDataArray.addAll(mediDataList);
    }

    public class ViewHolder {
        TextView textView;
    }

    @Override
    public int getCount() {
        return mediDataList.size();
    }

    @Override
    public MediData getItem(int position) {
        return mediDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if(convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.medi_item, null);
            holder.textView = (TextView)convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(mediDataList.get(position).getName());

        return convertView;
    }

    public void filter(String searchKeyword) {
        searchKeyword = searchKeyword.toLowerCase(Locale.getDefault());
        mediDataList.clear();
        if(searchKeyword.length() == 0) {
            mediDataList.addAll(mediDataArray);
        }
        else {
            for(MediData medi : mediDataArray ) {
                if(medi.getName().toLowerCase(Locale.getDefault()).contains(searchKeyword)) {
                    mediDataList.add(medi);
                }
            }
        }
        notifyDataSetChanged();
    }
}
