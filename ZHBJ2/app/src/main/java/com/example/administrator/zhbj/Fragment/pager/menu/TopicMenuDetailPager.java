package com.example.administrator.zhbj.Fragment.pager.menu;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**四级页面专题
 * Created by Administrator on 2016/6/29.
 */
public class TopicMenuDetailPager extends BaseMenuDatailPager {

    /**
     * 构造方法
     * @param activity
     */
    public TopicMenuDetailPager(Activity activity) {
        super(activity);
    }

    @Override
    public View initView() {
        TextView contentView=new TextView(mActivity);
        contentView.setText("四级页面的：专题");
         contentView.setBackgroundColor(Color.WHITE);
        contentView.setTextColor(Color.RED);
        contentView.setGravity(Gravity.CENTER);
          return contentView;
    }
}
