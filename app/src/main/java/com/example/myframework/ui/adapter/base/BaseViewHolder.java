package com.example.myframework.ui.adapter.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by 陈行 on 2018/12/4.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener,View.OnLongClickListener {


    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    public interface OnItemClickListener{
        void onItemClick(int position,@NonNull View view);
    }

    public interface OnItemLongClickListener{
        boolean onItemLongClick(int position,@NonNull View view);
    }
}
