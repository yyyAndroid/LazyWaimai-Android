package com.cheikh.lazywaimai.util;

import android.view.View;

/**
 * View的时间监听接口
 * @param <T>
 */
public interface ViewEventListener<T> {
   void onViewEvent(int actionId, T item, int position, View view);
}