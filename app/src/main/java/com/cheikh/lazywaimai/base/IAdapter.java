package com.cheikh.lazywaimai.base;

import com.cheikh.lazywaimai.util.ViewEventListener;
import java.util.List;

public interface IAdapter<T> {
    /**
     * 设置item集合
     * @param items
     */
    void setItems(List<T> items);

    /**
     * 添加单个条目
     * @param item
     */
    void addItem(T item);

    /**
     * 删除单个条目
     * @param item
     */
    void delItem(T item);

    /**
     * 添加条目集合
     * @param items
     */
    void addItems(List<T> items);

    /**
     * 删除所有条目
     */
    void clearItems();

    /**
     * 得到指定条目
     * @param position
     * @return
     */
    T getItem(int position);

    /**
     * 得到时间监听
     * @return
     */
    ViewEventListener<T> getViewEventListener();

    /**
     *设置View的时间监听
     * @param viewEventListener
     */
    void setViewEventListener(ViewEventListener<T> viewEventListener);
}