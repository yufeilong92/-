package com.example.administrator.zhbj.Fragment.pager.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.zhbj.Activity.NewDatilActivity;
import com.example.administrator.zhbj.Bean.NewListData;
import com.example.administrator.zhbj.Constant.GloableConstant;
import com.example.administrator.zhbj.R;
import com.example.administrator.zhbj.Utils.CacheUtils;
import com.example.administrator.zhbj.Utils.InnerViewPager;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

/**
 * Created by Administrator on 2016/6/30.\
 * 显示新闻列表界面
 * 列表的头部  --轮播大图+指示器
 * 列表本身--访问服务器获取数据--》解析数据--创建Adapter--设置listview
 */
public class NewsListViewPager extends BaseMenuDatailPager {
    private static final String TAG = "测试结果";
    //[☆]加载新闻数据
    private List<NewListData.DataBean.NewsBean> newlist;
    private ListView listView;
    private NewsItemAdapter newsItemAdapter;
    private InnerViewPager mtopview;
    private TextView mtoptitle;
    private CirclePageIndicator mpagerIndicator;
    private TopnewAdapter topnewAdapter;
    private Handler mHandler = null;
    private View headview;
    private View view;

    /**
     * 构造方法
     *
     * @param
     */
    public NewsListViewPager(Activity activity) {
        super(activity);
    }

    private List<NewListData.DataBean.TopnewsBean> topnewsBeenlist;

    /**
     * 方法
     *
     * @return
     */
    @Override
    public View initView() {
        view = View.inflate(mActivity, R.layout.paget_base_newslist, null);
        headview = View.inflate(mActivity, R.layout.paget_base_newslhead, null);
        mtopview = (InnerViewPager) headview.findViewById(R.id.base_news_ViewPager_topnews);

        mtopview.setId((int) System.currentTimeMillis());
        mtoptitle = (TextView) headview.findViewById(R.id.tv_newlist_tiltle);
        mpagerIndicator = (CirclePageIndicator) headview.findViewById(R.id.pager_indicator);

        mpagerIndicator.setId((int) System.currentTimeMillis());

        //[☆]列表头部视图通过addheadView方法添加列表的顶部
        listView = (ListView) view.findViewById(R.id.base_news_listview);

        listView.setId((int) System.currentTimeMillis());
        listView.addHeaderView(headview);


        //[☆]大图集合
        topnewsBeenlist = new ArrayList<NewListData.DataBean.TopnewsBean>();
        //[☆]大图适配器
        topnewAdapter = new TopnewAdapter();
        //[☆]添加指示器
        mtopview.setAdapter(topnewAdapter);
        //[☆]给指示器
        mpagerIndicator.setViewPager(mtopview);

        //[☆]Gson bean的数据集合
        newlist = new ArrayList<NewListData.DataBean.NewsBean>();
        //[☆]解析器
        newsItemAdapter = new NewsItemAdapter();
        //[☆]设置解析器
        listView.setAdapter(newsItemAdapter);
        initListeners();
        return view;
    }


    private class TopnewAdapter extends PagerAdapter {

        private BitmapUtils bitmapUtils;

        public TopnewAdapter() {
            bitmapUtils = new BitmapUtils(mActivity);
            bitmapUtils.configDefaultLoadingImage(R.drawable.topnews_item_default);
        }

        /**
         * 轮播大图多少
         *
         * @return
         */
        @Override
        public int getCount() {
            return topnewsBeenlist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
            ImageView imgae = new ImageView(mActivity);
            imgae.setImageResource(R.drawable.topnews_item_default);
            //[☆]获取显示数据
            NewListData.DataBean.TopnewsBean topnewsBean = topnewsBeenlist.get(position);
            //[☆]设置标题
            mtoptitle.setText(topnewsBean.getTitle());
            //[☆]加载图片
            bitmapUtils.display(imgae, topnewsBean.getTopimage());
            //[☆]图片等待加载器加载
            container.addView(imgae);
            return imgae;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }

    private class NewsItemAdapter extends BaseAdapter {

        private ViewHolderNewsItem hodler;
        //[☆]图片加载工具
        private final BitmapUtils bitmapUtils;

        /**
         * 构造方法
         */
        public NewsItemAdapter() {
            bitmapUtils = new BitmapUtils(mActivity);
            //[☆]配置加载中的缓存图
            bitmapUtils.configDefaultLoadingImage(R.drawable.news_pic_default);
        }

        @Override
        public int getCount() {
            return newlist.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        /**
         * 方法返回条目视图
         *
         * @param position
         * @param convertView
         * @param viewGroup
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            //[☆]优化
            //[☆]1数据
            NewListData.DataBean.NewsBean newsBean = newlist.get(position);
            //[☆]2视图
            if (convertView == null) {
                hodler = new ViewHolderNewsItem();
                convertView = View.inflate(mActivity, R.layout.item_news, null);
                hodler.icon = (ImageView) convertView.findViewById(R.id.iv_icon);
                hodler.title = (TextView) convertView.findViewById(R.id.tv_text);
                hodler.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
                //[☆]绑定
                convertView.setTag(hodler);
            } else {
                //[☆]把查找的view缓存起来方便多次重用
//                不用重新构建VIEW，利用系统中缓存的VIEW，可以提高效率
                hodler = (ViewHolderNewsItem) convertView.getTag();
            }
            //[☆]3赋值
            //[☆]设置标题
            hodler.title.setText(newsBean.getTitle());
//            设置上市时间
            hodler.tv_date.setText(newsBean.getPubdate());
//            加载图片
            bitmapUtils.display(hodler.icon, newsBean.getListimage());
//           显示已读的与未读状态

            String reads_ids = CacheUtils.getstring(mActivity, "read_ids");
            if (reads_ids.contains(newsBean.getId() + "")) {
                //[☆]已读显示灰色
                hodler.title.setTextColor(Color.GRAY);
            } else {
                hodler.title.setTextColor(Color.BLACK);
            }

            return convertView;
        }
    }


    public static class ViewHolderNewsItem {
        public ImageView icon;
        public TextView title;
        public TextView tv_date;

    }

    /**
     * c初始化页面的数据方法
     *
     * @param params 相对地址
     */
    @Override
    public void initData(Object params) {
        super.initData(params);
        //[☆]缓存
        final String relativePath = (String) params;
        String url = GloableConstant.SERVER_HOST + relativePath;
        //[☆]发送请求
        //[☆]从sp缓存里面读取出json
        String cache = CacheUtils.getstring(mActivity, relativePath);

        if (!TextUtils.isEmpty(cache)) {
            processData(cache);
        }
        //[☆]发送请求
        HttpUtils httpUtils = new HttpUtils();
        //[☆]创建回调对象处理返回值
        RequestCallBack<String> callBack = new RequestCallBack<String>() {
            /**
             * 方法
             * 失败
             * @param responseInfo
             */
            @Override
            public void onSuccess(ResponseInfo responseInfo) {
                CacheUtils.saveString(mActivity, relativePath, (String) responseInfo.result);
                Log.i("onFailure:relativePath ", "relativePathq请求成功" + responseInfo.result);


            }

            @Override
            public void onFailure(HttpException e, String s) {
                Log.i("onFailure:relativePath ", "relativePathq请求失败" + e.getMessage());
            }
        };
        httpUtils.send(HttpRequest.HttpMethod.GET, url, callBack);
    }

    private void processData(String cache) {
        //[☆]修该图片路径
        cache = cache.replaceAll("http://10.0.2.2:8080/zhbj/", GloableConstant.SERVER_HOST);
        Gson gson = new Gson();
        NewListData newListData = gson.fromJson(cache, NewListData.class);
//        Log.i("processData: ",newListData.toString());

        //[☆]加载刷新大图数据
        topnewsBeenlist.clear();

        topnewsBeenlist.addAll(newListData.getData().getTopnews());
        Log.d("news", newListData.getData().getTopnews().toString());
        //  topnewsBeenlist.add(newListData.getData().getTopnews());
        //[☆]调用指示器刷新大图
//        适配器的刷新 比指示器根好用
        topnewAdapter.notifyDataSetChanged();

        //[☆]加载服务端解析的数据
        newlist.clear();
        newlist.addAll(newListData.getData().getNews());
        //[☆]刷新列表通知主线程集合改变得了需要刷新
        newsItemAdapter.notifyDataSetChanged();
        if (mHandler == null) {
            mHandler = new Handler() {
                /**
                 * f方法
                 * @param msg
                 */
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    int currentItem = mtopview.getCurrentItem();
                    //[☆]显示下一页
                    currentItem++;
                    if (currentItem > topnewsBeenlist.size() - 1) {
                        currentItem = 0;
                    }
                    mtopview.setCurrentItem(currentItem);
                    //[☆]已经执行handleMeassage;
                    mHandler.removeMessages(1);
                    //[☆]循环进下一页播放
                    Message msg1 = new Message();
                    msg1.what = 1;
                    mHandler.sendMessageDelayed(msg1, 3000);

                }
            };
        }
        if (topnewsBeenlist.size() > 0) {
            Message msg = new Message();
            msg.what = 1;
            //[☆]延时发送
            mHandler.sendMessageDelayed(msg, 3000);
        }
    }

    /**
     * 方法给当前页面的控件添加监听器
     */
    private void initListeners() {
        mtopview.setOnTouchListener(new View.OnTouchListener() {
            /**
             *
             * @param view
             * @param motionEvent  动作的封装对象 ACTION_DOWN  ACTION_MOVE ACTION_UP
             * @return
             */
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case ACTION_DOWN://按下
                        Log.i(TAG, "ACTION_DOWN: 执行了按下的方法");
                        break;
                    case ACTION_UP://重新发送一个消息
                        Log.i(TAG, "ACTION_UP:执行流的松手的方法");
                        Message message = new Message();
                        message.what = 1;
                        mHandler.sendMessageDelayed(message, 3000);
                        break;
                    case ACTION_MOVE://移走
                        Log.i(TAG, "onTouch:执行移走的方法 ");
                        break;
                    case ACTION_CANCEL://滑动别的控件没法响应
                        Log.i(TAG, "onTouch:y移动到别人的控件 ");
                        Message message1 = new Message();
                        message1.what = 1;
                        mHandler.sendMessageDelayed(message1, 3000);
                        break;
                }
                return false;//不要轻易消费事件
            }
        });
//        用于监听点击网址的显示
        //[☆]添加监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /**listview .addview添加轮播图器占了一个位置
                 * 在其下标减去一*/
                // 只需要减去headview的数量
                // [☆]根据小标回去页面
                i = i - listView.getHeaderViewsCount();
                NewListData.DataBean.NewsBean newsBean = newlist.get(i);
                Toast.makeText(mActivity, i + ":" + newsBean.getTitle(), Toast.LENGTH_SHORT).show();
                String readids = CacheUtils.getstring(mActivity, "read_ids");
                if (!readids.contains(newsBean.getId() + "")) {
                    CacheUtils.saveString(mActivity, "read_ids", readids + "|" + newsBean.getId());
                }
                //[☆]整表刷新不可取，性能较低
//                newsItemAdapter.notifyDataSetChanged();//列表listView整体刷新通知UI
//          性能较好
              //   TextView tv_title = (TextView) view.findViewById(R.id.tv_text);
//                tv_title.setTextColor(Color.GRAY);
                //[☆]里面存的是find过的控件
                //[☆]性能最好
                ViewHolderNewsItem holder = (ViewHolderNewsItem) view.getTag();
                holder.title.setTextColor(Color.GRAY);
                //[☆]列表的listview整体刷新 通知ui
//                getview 根据保存的id来判断显示黑色还是灰色
                newsItemAdapter.notifyDataSetChanged();
                Intent intent = new Intent(mActivity, NewDatilActivity.class);
                intent.putExtra("url", newsBean.getUrl());
                mActivity.startActivity(intent);

            }
        });
    }

}
