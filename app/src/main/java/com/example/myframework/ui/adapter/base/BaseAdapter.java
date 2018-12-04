package com.example.myframework.ui.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by 陈行 on 2018/12/4.
 */

public class BaseAdapter<VH extends BaseViewHolder,D extends Object> extends RecyclerView.Adapter<VH>{


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
