package com.example.hyebeen.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> {

        private ArrayList<MediData> mList = null;
        private Activity context = null;


    public UsersAdapter(Activity context, ArrayList<MediData> list) {
            this.context = context;
            this.mList = list;
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {
            protected TextView disease;
            protected TextView name;
            protected TextView take;


            public CustomViewHolder(View view) {
                super(view);
                this.disease = (TextView) view.findViewById(R.id.textView_list_id);
                this.name = (TextView) view.findViewById(R.id.textView_list_name);
                this.take = (TextView) view.findViewById(R.id.textView_list_country);
            }
        }


        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
            CustomViewHolder viewHolder = new CustomViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

            viewholder.disease.setText(mList.get(position).getMember_info());
            viewholder.name.setText(mList.get(position).getMember_name());
            viewholder.take.setText(mList.get(position).getMember_take());
        }

        @Override
        public int getItemCount() {
            return (null != mList ? mList.size() : 0);
        }

    }
