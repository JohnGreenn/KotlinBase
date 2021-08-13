package com.hpkj.kotlinbase.widget.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * desc：禁用水平滑动的ViewPager
 * author：Glq
 * time：2021/08/11 15:44
 */
class NoScrollViewPager : ViewPager{

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        //不拦截这个事件
        return false
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        //不处理这个事件
        return false
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item,Math.abs(currentItem - item) ==1);
    }

}