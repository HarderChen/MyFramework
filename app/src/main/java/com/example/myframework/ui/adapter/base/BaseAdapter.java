package com.example.myframework.ui.adapter.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myframework.ui.fragment.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by 陈行 on 2018/12/4.
 */

public abstract class BaseAdapter<VH extends BaseViewHolder,D extends Object>
        extends RecyclerView.Adapter<VH> implements BaseViewHolder.OnItemClickListener,BaseViewHolder.OnItemLongClickListener{

    //item点击回调
    private BaseViewHolder.OnItemClickListener mOnItemClickListener;

    //item长按回调
    private BaseViewHolder.OnItemLongClickListener mOnItemLongClickListener;

    protected ArrayList<D> data;
    protected Context context;
    protected BaseFragment fragment;

    public BaseAdapter(Context context) {
        this.context = context;
    }

    public BaseAdapter(Context context, BaseFragment fragment) {
        this.context = context;
        this.fragment = fragment;
    }

    public ArrayList<D> getData() {
        return data;
    }

    public void setData(ArrayList<D> data) {
        this.data = data;
    }

    public void setOnItemClickListener(BaseViewHolder.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(BaseViewHolder.OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType),parent,false);
        VH viewHolder = getViewHolder(itemView,viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if(mOnItemClickListener != null){
            holder.setOnItemClickListener(this);
        }

        if(mOnItemLongClickListener != null){
            holder.setOnItemLongClickListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        mOnItemClickListener.onItemClick(position,view);
    }

    @Override
    public boolean onItemLongClick(int position, @NonNull View view) {
        return mOnItemLongClickListener.onItemLongClick(position,view);
    }

    protected abstract int getLayoutId(int viewType);

    protected abstract VH getViewHolder(View itemView, int viewType);

    @NonNull protected String getString(@StringRes int resId){
        return context.getString(resId);
    }

}
