package com.cheikh.lazywaimai.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import com.cheikh.lazywaimai.util.ViewEventListener;

/**
 * author: cheikh.wang on 16/11/23
 * email: wanghonghi@126.com
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter implements IAdapter<T> {

    private List<T> mItems;
    private ViewEventListener<T> mViewEventListener;

    public BaseAdapter() {
        mItems = new ArrayList<>();
    }

    /**
     * 设置条目集合
     * @param items
     */
    @Override
    public void setItems(List<T> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * 添加多个条目
     * @param items
     */
    @Override
    public void addItems(List<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    /**
     * 添加单个条目
     * @param item
     */
    @Override
    public void addItem(T item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    /**
     * 删除单个条目
     * @param item
     */
    @Override
    public void delItem(T item) {
        mItems.remove(item);
        notifyDataSetChanged();
    }

    /**
     * 清除所有条目
     */
    @Override
    public void clearItems() {
        mItems.clear();
        notifyDataSetChanged();
    }

    /**
     * 得到某个条目
     * @param position
     * @return
     */
    @Override
    public T getItem(int position) {
        return mItems.get(position);
    }

    /**
     *
     * @param viewEventListener
     */
    @Override
    public void setViewEventListener(ViewEventListener<T> viewEventListener) {
        mViewEventListener = viewEventListener;
    }

    /**
     * 设置View的时间监听
     * @return
     */
    @Override
    public ViewEventListener<T> getViewEventListener() {
        return mViewEventListener;
    }

    /**
     * 得到条目的Id
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 得到条目的个数
     * @return
     */
    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    /**
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getViewLayoutId(viewType), parent, false);
        return createViewHolder(view, viewType);
    }

    /**
     * 绑定ViewHodler数据
     * @param viewHolder
     * @param position
     */
    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof IViewHolder) {
            IViewHolder<T> holder = (IViewHolder) viewHolder;
            holder.setViewEventListener(mViewEventListener);
            holder.setItem(getItem(position));
            holder.setPosition(position);
        }
        bindViewHolder(viewHolder, getItem(position), position);
    }

    /**
     * 得到ViewLayout
     * @param viewType
     * @return
     */
    public abstract int getViewLayoutId(int viewType);

    /**
     *
     * @param view
     * @param viewType
     * @return
     */
    public abstract RecyclerView.ViewHolder createViewHolder(View view, int viewType);

    /**
     * @param holder
     * @param item
     * @param position
     */
    public abstract void bindViewHolder(RecyclerView.ViewHolder holder, T item, int position);
}
