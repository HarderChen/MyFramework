package com.example.myframework.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myframework.R;

import java.util.ArrayList;

/**
 * Created by 陈行 on 2018/12/5 0005.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

   ArrayList<String>data;

    protected void initData()
    {
        data = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            data.add("" + (char) i);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

//    ArrayList<D> data;
//
//    public void setData(ArrayList<D> data) {
//        this.data = data;
//    }




    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_num);
        }
    }
}
