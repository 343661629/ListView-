package com.example.administrator.listviewtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11 0011.
 * 万能适配器
 */

public abstract class PowerfulAdapter<T> extends BaseAdapter {
    private Context mContext;
    private List<T> stringList;
    private int layoutId;


    public PowerfulAdapter(Context mContext, List<T> stringList,int layoutId) {
        this.mContext = mContext;
        this.stringList = stringList;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = ViewHolder.getViewHolder(convertView, mContext,layoutId); //获取ViewHolder对象
        convert(holder,stringList.get(position));
        return holder.getConvertView();
    }

    /**
     * 对外提供一个抽象方法
     */
    public abstract void convert(ViewHolder holder, T item);



}
