package com.example.administrator.zhbj.Fragment;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.zhbj.Bean.LeftMenuData;
import com.example.administrator.zhbj.Constant.GloableConstant;
import com.example.administrator.zhbj.R;
import com.example.administrator.zhbj.Utils.CacheUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * 二级页面菜单
 * Created by Administrator on 2016/6/24.
 */
public class LeftMenuFragment extends BaseFragment {
    private int positionHight = 0;
    private LeftMenuData leftMenuData;
    private ListView listView;
    private MenuAdapter.ViewHolderMenu holder;
    private MenuAdapter adapter;

    /**
     * 方法初始化片段的控件
     *
     * @return
     */
    @Override
    public View initview() {

        View view = View.inflate(mActivity, R.layout.frament_left_menu, null);
        //[☆]初始化数据

        listView = (ListView) view.findViewById(R.id.listview_menu);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * 方法
             * @param parent
             * @param view
             * @param position 点中item的下标
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                保存点中位置为高度
                switchMenuItem(position);
            }


        });
        initData();
        return view;
    }

    /**
     * 方法 切换菜单的时候完成高亮显示
     * 二，完成三级页面newsConterPagerd的标题与内容的切换
     * 使用广播与广播接收器是最简洁的
     *
     * @param position
     */
    private void switchMenuItem(int position) {
        positionHight = position;
        //[☆]重新显示列表
        adapter.notifyDataSetChanged();//getview重新调用选中的高亮，反之不高亮
        Intent broadcast = new Intent();
        switch (position) {
            case 0:
                //[☆]
                broadcast.setAction(GloableConstant.ACION_LEFT_MENU_NEWS);
                 //[☆]javabean对象实现序列化接口包含其子元素也实现序列化
                broadcast.putExtra("data",leftMenuData);
                break;
            case 1:
                broadcast.setAction(GloableConstant.ACION_LEFT_MENU_TOPIC);
                break;
            case 2:
                broadcast.setAction(GloableConstant.ACION_LEFT_MENU_TPHOTO);
                break;
            case 3:
                broadcast.setAction(GloableConstant.ACION_LEFT_MENU_INTERACTIVE);
                break;
        }
        mActivity.sendBroadcast(broadcast);
    }

    /***
     * 获取服务端的数据到本地界面显示
     */
    @Override
    public void initData() {
        super.initData();
        //[☆]获取路径
        String url = GloableConstant.SERVER_HOST + GloableConstant.URL_LEFT_MENU_DATA;
        //[☆]缓存数据
        String cache = CacheUtils.getstring(mActivity, GloableConstant.URL_LEFT_MENU_DATA);
         if(!TextUtils.isEmpty(cache)){
//             显示到界面上
             /**
              * 有可能是旧数据，所以继续想服务器发送请求
              */
             processData(cache);
         }
        //[☆]发送请求
//        xutils有一个http工具类Httputils能够进行http请求的工具类可以向服务器发送
        HttpUtils httpUtils = new HttpUtils();
//        new RequestCallBack<T>(){T指定类型}
        //[☆]返回类型
        RequestCallBack<String> requestCallBack = new RequestCallBack<String>() {
            /**
             * 请求成功
             * @param responseInfo
             */
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Log.i("onSuccess: ", "请求成功" + responseInfo.result);
                //[☆]显示到界面上并且保存到本来
                processData(responseInfo.result);
                //[☆]更新缓存，由使用的是sP保存，sp文件在data/data/包名/config.xml
                CacheUtils.saveString(mActivity,GloableConstant.URL_LEFT_MENU_DATA,responseInfo.result);
            }

            /**请求失败后的显示
             *
             * @param e
             * @param s
             */
            @Override
            public void onFailure(HttpException e, String s) {
                Log.i("onFailure: ", "数据请求失败"+s.toString());

            }
        };
//        httpUtils.send(method 请求方式post/get ,url 服务器地址，callback回调当服务器端返回时需要一个接收数据对象)
        //[☆]发送请求

        httpUtils.send(HttpRequest.HttpMethod.GET, url, requestCallBack);

    }

    /***
     * 解析Gson
     */
    private void processData(String result) {
        //[☆]解析gson使用工具
        Gson gson = new Gson();
//        gson.fromJson(json  json字符串，classofT 字符串对应得类)
        //[☆]解析gson
        leftMenuData = gson.fromJson(result, LeftMenuData.class);
        Log.i("processData: ", "----解析后的对象数据" + leftMenuData.toString());
        showListView();
    }

    /**
     * 方法 高级控件ListView显示集合会不会？优化ListView
     * 显示菜单
     */
    private void showListView() {
        adapter = new MenuAdapter();
        listView.setAdapter(adapter);

//        switchMenuItem(0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switchMenuItem(0);
            }
        },500);

    }

    private class MenuAdapter extends BaseAdapter {
        /**
         * 返回集合的长度
         *
         * @return
         */
        @Override
        public int getCount() {
            return leftMenuData.getData().size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        class ViewHolderMenu {
            public TextView listview_menu;
        }

        /**
         * 返回条目的视图
         *
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //1[☆]数据
            LeftMenuData.DataBean menuData = leftMenuData.getData().get(position);
            //2[☆]视图
            if (convertView == null)//1优化inflate  2 findViewByid
            {
                convertView = View.inflate(mActivity, R.layout.item_menu, null);
                holder = new ViewHolderMenu();
                holder.listview_menu = (TextView) convertView.findViewById(R.id.menu_title);
                //[☆]绑定视图以后有视图就有hodler
                convertView.setTag(holder);
             //[☆]重用视图
            } else {
                holder = (ViewHolderMenu) convertView.getTag();
            }
            //3[☆]赋值
//            Log.i("getView: ", "" + menuData.getTitle());
//            Log.i("getView:> ", "" + holder.listview_menu);
            holder.listview_menu.setText(menuData.getTitle());
            //  holder.listview_menu.set
            //[☆]高亮处理
            if (position == positionHight) {
                holder.listview_menu.setSelected(true);
            } else {
                holder.listview_menu.setSelected(false);
            }
            return convertView;
        }
    }
}
