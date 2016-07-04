package com.example.administrator.zhbj.Utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/7/2.
 */
public class InnerViewPager extends ViewPager {

    /**+
     *
     * @param context
     */
    public InnerViewPager(Context context, AttributeSet attrs) {
        super(context,attrs);
//        getParent()就是外层viewpager
//       .requestDisallowInterceptTouchEvent();
//        requestDisallowInterceptTouchEvent();true 拦截成功
//        将父类的onItenterceptTouchEvent强改成false
        //[☆]外部的ONinterceptTouchEvent return false事件下发

    }
   int startx;
    int starty;
    /**
     * 父类事件下发时候
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //判断出左右滑动
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startx= (int) event.getX();
                starty= (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int newx = (int) event.getX();
                int newy = (int) event.getY();
              int dx=newx-startx;
                int dy = newy-starty;
                if (Math.abs(dx)>Math.abs(dy)){
//                    左右滑动
//                    最右边的大图
                    //[☆]处理滑到最后一页不能重新滑定
                    int currentItem = getCurrentItem();//获取当前页的下标
                    //[☆]d第页往左托不能滑动
                    if(currentItem==0&&(dx>0)){
                        //[☆]第一页
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    if(currentItem==(getAdapter().getCount()-1)){
                     //[☆]外层OnInterceptTouchEvent改为true
//                        使他继续执行
                    getParent().requestDisallowInterceptTouchEvent(false);
                    }

                }else {
//                    上下滑动
                    //[☆]拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }

        return super.dispatchTouchEvent(event);
    }
}
