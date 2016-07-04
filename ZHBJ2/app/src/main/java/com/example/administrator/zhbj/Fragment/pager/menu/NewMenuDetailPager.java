package com.example.administrator.zhbj.Fragment.pager.menu;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.zhbj.Bean.LeftMenuData;
import com.example.administrator.zhbj.R;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 四级页面频道
 * Created by Administrator on 2016/6/29.
 */
public class NewMenuDetailPager extends BaseMenuDatailPager {

    private TabPageIndicator mTabPageIndicator;
    private ViewPager mviewPager;
    private final ArrayList<NewsListViewPager> mPager;

    /**
     * 构造方法
     *
     * @param activity
     */
    public NewMenuDetailPager(Activity activity) {
        super(activity);
        mPager = new ArrayList<NewsListViewPager>();
    }

    /**
     * 方法 初始化四级页面的控件
     *
     * @return
     */
    @Override
    public View initView() {
//        TextView contentView=new TextView(mActivity);
//        contentView.setText("四级页面的：频道");
//         contentView.setBackgroundColor(Color.WHITE);
//        contentView.setTextColor(Color.RED);
//        contentView.setGravity(Gravity.CENTER);
        View view = View.inflate(mActivity, R.layout.men_datail_pager_news, null);
        mTabPageIndicator = (TabPageIndicator) view.findViewById(R.id.viewpager_tabinidcator);
        mviewPager = (ViewPager) view.findViewById(R.id.ment_deital_pager_viewpager);
        //[☆]指示器的id
        mTabPageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *
             * @param position
             * @param positionOffset
             * @param positionOffsetPixels
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 选中的新闻频道时加的指示器可以再次加载数据
             * @param position
             */
            @Override
            public void onPageSelected(int position) {
                loadNewsListPagerData(position);

            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

    private void loadNewsListPagerData(int position) {
        //[☆]获取加载的新闻页面
        NewsListViewPager newsListViewPager = mPager.get(position);
        LeftMenuData.DataBean.ChildrenBean childrenBean = categorys.get(position);
        //[☆]相对地址
        newsListViewPager.initData(childrenBean.getUrl());
    }

    private List<LeftMenuData.DataBean.ChildrenBean> categorys = new ArrayList<>();


    /**
     * 方法:
     * 获取数据
     *
     * @param params
     */
    @Override
    public void initData(Object params) {
        super.initData(params);
        LeftMenuData data = (LeftMenuData) params;
        //[☆]编写代码
        categorys.clear();
        //[☆]访问数据第一个新闻的children
        categorys.addAll(data.getData().get(0).getChildren());

        //[☆]显示viewpager
        CategoryPager categoryPager = new CategoryPager();
        mviewPager.setAdapter(categoryPager);
        //[☆]在显示指示器
        mTabPageIndicator.setViewPager(mviewPager);
        //[☆]重写adapter的getPagetitle方法拿到文字
        for (int i = 0; i < categorys.size(); i++) {
            NewsListViewPager newsListViewPager = new NewsListViewPager(mActivity);
            mPager.add(newsListViewPager);
        }
        if (categorys.size() > 0) {
            loadNewsListPagerData(0);
        }
    }

    /**
     * 显示多个新闻频道页面的数据
     */
    private class CategoryPager extends PagerAdapter {

        /**
         * 方法返回指示器的文字
         *
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return categorys.get(position).getTitle();
        }

        /**
         * 方法：频道数
         *
         * @return
         */
        @Override
        public int getCount() {
            return categorys.size();
        }

        /**
         * 固定写法
         *
         * @param view
         * @param object
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            return super.instantiateItem(container, position);
//            TextView textView=new TextView(mActivity);
//            LeftMenuData.DataBean.ChildrenBean childrenBean = categorys.get(position);
//            textView.setText("当频道为："+childrenBean.getTitle());
//            textView.setGravity(Gravity.CENTER);
//           textView.setBackgroundColor(Color.GREEN);
//            textView.setTextSize(30);
//            textView.setTextColor(Color.BLACK);
//            //[☆]显示滑动页面
//            container.addView(textView);

            NewsListViewPager newsListViewPager = mPager.get(position);
            //[☆]添加新闻列表事件
            View view = newsListViewPager.mRootView;
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
