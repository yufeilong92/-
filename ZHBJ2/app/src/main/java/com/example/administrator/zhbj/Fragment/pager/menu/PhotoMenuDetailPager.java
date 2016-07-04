package com.example.administrator.zhbj.Fragment.pager.menu;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.zhbj.Constant.GloableConstant;
import com.example.administrator.zhbj.R;
import com.example.administrator.zhbj.Utils.CacheUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * 四级页面组图
 * Created by Administrator on 2016/6/29.
 */
public class PhotoMenuDetailPager extends BaseMenuDatailPager {

    private ListView mlistview;
    private GridView mgirview;
    private ImageView mIvRight;
    private static final String TAG="组图数据";

    /**
     * 构造方法
     *
     * @param activity+++
     * @param mTVRight
     */
    public PhotoMenuDetailPager(Activity activity, ImageView mTVRight) {
        super(activity);
        mIvRight = mTVRight;
        mIvRight.setImageResource(View.VISIBLE);
        initListeners();
    }

    private boolean islistview = true;

    @Override
    public View initView() {
//        TextView contentView=new TextView(mActivity);
//        contentView.setText("四级页面的：组图");
//         contentView.setBackgroundColor(Color.WHITE);
//        contentView.setTextColor(Color.RED);
//        contentView.setGravity(Gravity.CENTER);
        View view = View.inflate(mActivity, R.layout.menu_detail_pager_phone, null);
        mlistview = (ListView) view.findViewById(R.id.listview_phone);
        mgirview = (GridView) view.findViewById(R.id.listview_gridview);

        return view;
    }

    /**
     * 当前是组图鉴定器添加方法
     */
    private void initListeners() {
        mIvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                islistview = !islistview;
                if (islistview) {//显示列表
                    mlistview.setVisibility(View.VISIBLE);
                    mgirview.setVisibility(View.GONE);
                    mIvRight.setImageResource(R.drawable.icon_pic_grid_type);
                } else {//显示网格视图
                    mlistview.setVisibility(View.GONE);
                    mgirview.setVisibility(View.VISIBLE);
                    mIvRight.setImageResource(R.drawable.icon_pic_list_type);
                }
            }
        });
    }

    @Override
    public void initData(Object params) {
        super.initData(params);
//        photos/photos_1.json
        /**
         *   先从本地取缓存
         *   发请求到服务端获取新的的数据与跟新界面与缓存
         */
        final String cache = CacheUtils.getstring(mActivity, GloableConstant.URL_PHOTO);
        if (!TextUtils.isEmpty(cache)) {
            processData(cache);
        }
        String url = GloableConstant.SERVER_HOST + GloableConstant.URL_PHOTO;
        Log.i(TAG, "initData: "+ url);
        //[☆]创建请求工具
        HttpUtils httpUtils = new HttpUtils();
        RequestCallBack<String>  callback=new RequestCallBack<String>() {
            /**
             *
             * @param responseInfo
             */
            @Override
            public void onSuccess(ResponseInfo responseInfo) {
               processData(cache);
                //[☆]缓存
                CacheUtils.saveString(mActivity,GloableConstant.URL_PHOTO, (String) responseInfo.result);
            }

            /**
             *
             * @param e
             * @param s
             */
            @Override
            public void onFailure(HttpException e, String s) {
            }
        };

        httpUtils.send(HttpRequest.HttpMethod.GET,url,callback);
    }

    private void processData(String cache) {
        Log.i(TAG, "processData: "+cache.toString());
    }
}
