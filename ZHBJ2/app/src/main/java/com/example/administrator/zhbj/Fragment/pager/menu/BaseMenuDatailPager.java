package com.example.administrator.zhbj.Fragment.pager.menu;

import android.app.Activity;
import android.view.View;

/**四级页面的基类
 * 四级和三级的区别 :没有标题元素
 * 基类的目标以最少的代码实现相同功能
 * Created by Administrator on 2016/6/29.
 */
public abstract class BaseMenuDatailPager {
     /**上下文*/
    public Activity mActivity;
    /**四级页面的视图*/
    public View mRootView;

    /**
     * 构造方法
     * @param activity
     */
    public BaseMenuDatailPager(Activity activity){
        super();
        this.mActivity=activity;
        mRootView=initView();
    }

    /***方法
     * 初始化页面四级页面的控件
     *
     * @return
     */
    public abstract View initView();

    /**
     * 方法初始化四级页面的数据
     * @param params
     */
    public void initData(Object params) {

    }
}
