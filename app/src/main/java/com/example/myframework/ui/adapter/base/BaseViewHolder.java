package com.example.myframework.ui.adapter.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import butterknife.ButterKnife;

/**
 * Created by 陈行 on 2018/12/4.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener,View.OnLongClickListener {

    //item点击回调
    private OnItemClickListener mOnItemClickListener;

    //item长按回调
    private OnItemLongClickListener mOnItemLongClickListener;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
        itemView.setOnClickListener(this);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mOnItemClickListener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
            mOnItemClickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if(mOnItemLongClickListener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
            return mOnItemLongClickListener.onItemLongClick(getAdapterPosition(), view);
        }
        return false;
    }

    public interface OnItemClickListener{
        void onItemClick(int position,@NonNull View view);
    }

    public interface OnItemLongClickListener{
        boolean onItemLongClick(int position,@NonNull View view);
    }
}
