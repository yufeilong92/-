package com.example.administrator.zhbj.Activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.administrator.zhbj.R;

/**
 * Created by Administrator on 2016/7/4.
 * 新闻详情界面
 */
public class NewDatilActivity extends Activity {

    private WebView mwebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //[☆]设置不显示标题
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_new_detail);
       initview();
        initData();
        initlisteners();
//      获取打开自己地址
        Intent intent = getIntent();
        String[] urls = intent.getStringArrayExtra("url");


    }

    /**
     * 打开选中的字体对话框
     */
    private void initlisteners() {
//        iv_back
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.iv_icon_textsize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTextSizeDialog();

            }
        });
    }

    private void showTextSizeDialog() {
        //[☆]弹出对话框
        //超大号字体
        //大号字体
        //正常字体
        //超小号字体
        //[☆]对话框只能传activity上下文，其他一律报错
        AlertDialog.Builder builder = new AlertDialog.Builder(NewDatilActivity.this);
        builder.setTitle("设置字号");
        //SingleChoice单选的三个参数
        String[] items=new String[]{
                "超大号字体","大号字体","正常字体",
                "超小号字体"
        };

//                builder.setSingleChoiceItems(items,选择文字，checkeditem默认打开位置，initlisteners();点击监听器)
        builder.setSingleChoiceItems(items,2, new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        mwebview.getSettings().setTextSize(WebSettings.TextSize.LARGEST);
                        break;
                    case 1:
                        mwebview.getSettings().setTextSize(WebSettings.TextSize.LARGER);
                        break;
                    case 2:
                        mwebview.getSettings().setTextSize(WebSettings.TextSize.NORMAL);
                        break;
                    case 3:
                        mwebview.getSettings().setTextSize(WebSettings.TextSize.SMALLER);
                        break;
                    case 4:
                        mwebview.getSettings().setTextSize(WebSettings.TextSize.SMALLEST);

                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("取消", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
//                显示
        builder.show();

    }

    private void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
//        String url="http://192.168.56.1:8080/";
//        根据地址加载网页数据
        mwebview.loadUrl(url);
//        配置网页设置可以加载js
        WebSettings settings = mwebview.getSettings();
//        设置支持js
        settings.setJavaScriptEnabled(true);
       //[☆]设置缩放按钮
        settings.setBuiltInZoomControls(true);
        //[☆]设置双击缩放
        settings.setUseWideViewPort(true);
//        回调对象：提供处理方法的对象
//       可以防止打开系统自带的浏览器
//        WebViewClient:webview 的回调对象可以防止打开系统自带的浏览器
//        同时提供三个处理方法
//        网页开始加载
//        网页结束加载
//        重写加载地址

        mwebview.setWebViewClient(new WebViewClient(){
            /**
             * 加载前显示缓存视图
             * @param view
             * @param url
             * @param favicon
             */
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
               //[☆]开始显示回见
                findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
            }

            /**
             * 关闭缓冲视图
             * @param view
             * @param url
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                findViewById(R.id.progressBar).setVisibility(View.GONE);
            }

//            /**
//             * 重写跳转的路径
//             * 进入页面重新跳转的页面
//             * 针对跳转的路径而不是loadUrl路径
//             * @param view
//             * @param url
//             * @return
//             */
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl("http://192.168.56.1:8080/");
//                return true;
//
//            }
        });
        //[☆]在学习一个回调对象，回来获取加载进度
        //[☆]WebChromeClient:谷歌浏览器  提供进度加载方法的回调对象
       mwebview.setWebChromeClient(new WebChromeClient(){
           /**
            * 进度加载方法
            * @param view
            * @param newProgress 加载中的进度百分比
            */
           @Override
           public void onProgressChanged(WebView view, int newProgress) {
               super.onProgressChanged(view, newProgress);

               ProgressBar percent = (ProgressBar) findViewById(R.id.progress);
               if(newProgress==100){
                   percent.setVisibility(View.GONE);
               }else {
                   percent.setVisibility(View.VISIBLE);
                   percent.setProgress(newProgress);
               }
           }
       });

    }


    private void initview() {
        mwebview = (WebView) findViewById(R.id.webview);

    }

}
