package com.example.administrator.zhbj.Fragment.pager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.zhbj.Activity.MAinActivitys;
import com.example.administrator.zhbj.Bean.LeftMenuData;
import com.example.administrator.zhbj.Constant.GloableConstant;
import com.example.administrator.zhbj.Fragment.pager.menu.BaseMenuDatailPager;
import com.example.administrator.zhbj.Fragment.pager.menu.InteractMenuDetailPager;
import com.example.administrator.zhbj.Fragment.pager.menu.NewMenuDetailPager;
import com.example.administrator.zhbj.Fragment.pager.menu.PhotoMenuDetailPager;
import com.example.administrator.zhbj.Fragment.pager.menu.TopicMenuDetailPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/27.
 * 三级页面新闻中心
 */
public class NewsConterPager extends BasePager {

//[☆]管理四级页面
    private final ArrayList<BaseMenuDatailPager> mMenuPagers;

    /**
     * 构造方法
     */

    public NewsConterPager(final Activity mAtivity) {
        super(mAtivity);
        mMenuPagers = new ArrayList<BaseMenuDatailPager>();
        mMenuPagers.add(new NewMenuDetailPager(mAtivity));//新闻
        mMenuPagers.add(new TopicMenuDetailPager(mAtivity));//专题
        mMenuPagers.add(new PhotoMenuDetailPager(mAtivity ,mTVRight));//组图
        mMenuPagers.add(new InteractMenuDetailPager(mAtivity));//交互


//        注册广播接收器
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {



            /**
             * 方法
             * 接收左侧菜单的信号，更新标题与内容
             * @param context
             * @param intent
             */
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(mActivity,"菜单信号"+intent.getAction(),Toast.LENGTH_SHORT).show();
                if(intent.getAction().equals(GloableConstant.ACION_CLEAN_ALL_RECEIVERS)){
                   Toast.makeText(mAtivity,"清理广播接收者",Toast.LENGTH_SHORT).show();
                    mAtivity.unregisterReceiver(this);
                }else {

                showTileAndContent(intent);
                }
            }


        };
//        绑定广播
        IntentFilter intentFilter = new IntentFilter();
//        注册信号
        intentFilter.addAction(GloableConstant.ACION_LEFT_MENU_NEWS);
        intentFilter.addAction(GloableConstant.ACION_LEFT_MENU_TPHOTO);
        intentFilter.addAction(GloableConstant.ACION_LEFT_MENU_TOPIC);
        intentFilter.addAction(GloableConstant.ACION_LEFT_MENU_INTERACTIVE);
        intentFilter.addAction(GloableConstant.ACION_CLEAN_ALL_RECEIVERS);

//        注册广播  接收广播
        mActivity.registerReceiver(broadcastReceiver, intentFilter);


    }

    /**
     * g广播的显示内容
     * @param intent
     */
    private void showTileAndContent(Intent intent) {
        //             获取数据
         BaseMenuDatailPager currpager=null;
        mTVRight.setVisibility(View.GONE);
        //标题跟新：组图显示标题栏右侧按钮
        currpager = null;
        if(intent.getAction().equals(GloableConstant.ACION_LEFT_MENU_NEWS)){
            mTvTitle.setText("新闻");
            currpager =mMenuPagers.get(0);
            //[☆]给新闻频道页面拿到数据
            //[☆]给四级页面在三级页面设置页面
            LeftMenuData data = (LeftMenuData) intent.getSerializableExtra("data");
            //[☆]获取服务端数据
            currpager.initData(data);
        }else if (intent.getAction().equals(GloableConstant.ACION_LEFT_MENU_TOPIC)){
            mTvTitle.setText("专题");
            currpager =mMenuPagers.get(1);
        }else if (intent.getAction().equals(GloableConstant.ACION_LEFT_MENU_INTERACTIVE)){
            mTvTitle.setText("交互");
            currpager =mMenuPagers.get(3);
        }else if (intent.getAction().equals(GloableConstant.ACION_LEFT_MENU_TPHOTO)){
            mTvTitle.setText("组图");

            currpager =mMenuPagers.get(2);
            currpager.initData(null);
            mTVRight.setVisibility(View.VISIBLE);
        }

//                获取四级页面的视图
        View pagerView=currpager.mRootView;
//                清空三级页面的中间内容
        mContentView.removeAllViews();
//                把心得视图添加到中间页面
        mContentView.addView(pagerView);
        MAinActivitys mAinActivitys= (MAinActivitys) mActivity;
        //[☆]获取侧滑控件
        SlidingMenu slidingMenu = mAinActivitys.getSlidingMenu();
        //[☆]显示中间内容
        slidingMenu.showContent();
    }

    /**
     * F方法初始化页面控件
     *
     * @param contentview
     */
    @Override
    public void initView(FrameLayout contentview) {
        mTvTitle.setText("新闻中心");
        TextView view = new TextView(mActivity);
        view.setTextSize(22);
        mTVMenu.setVisibility(View.VISIBLE);
        view.setText("三级页面新闻中心");
        view.setTextColor(Color.RED);
        view.setGravity(Gravity.CENTER);
        contentview.addView(view);

    }
}
