package com.example.administrator.zhbj.Constant;

/**
 * Created by Administrator on 2016/6/28.
 * 保存整个项目的静态常量
 */
public class GloableConstant {
         /** 菜单不可用*/
         public  static  final String ACION_SLIDING_DISABLE="com.zdwl.action.ACION_SLIDING_DISABLE";
         /** 菜单可用*/
         public  static  final String ACION_SLIDING_ENABLE="com.zdwl.action.ACION_SLIDING_ENABLE";
        /**菜单状态切换*/
         public  static  final String ACION_SLIDING_TOGGLE="com.zdwl.action.ACION_SLIDING_TOGGLE";
      /**数据连接*/
    public static final String SERVER_HOST="http://192.168.56.1:8080/zhbj03/";
    public static final String URL_LEFT_MENU_DATA="/categories.json";
    public static final String URL_PHOTO="/photos/photos_1.json";

//   public static  final  String SERVER_HSOT="http://192.168.56.1:8080/zhbj03/"
            /**左侧菜单广播*/
            /* 新闻专题*/
    public static  final String  ACION_LEFT_MENU_NEWS="com.zdwl.cation.ACION_LEFT_MENU_NEWS";
            /* 专题*/
    public static  final String  ACION_LEFT_MENU_TOPIC="com.zdwl.cation.ACION_LEFT_MENU_TOPIC";
          /* 组图*/
    public static  final String  ACION_LEFT_MENU_TPHOTO="com.zdwl.cation.ACION_LEFT_MENU_TPHOTO";
          /* 交互*/
    public static  final String  ACION_LEFT_MENU_INTERACTIVE="com.zdwl.cation.ACION_LEFT_MENU_INTERACTIVE";
          /**只要接受该广播都移除*/
     public static  final String  ACION_CLEAN_ALL_RECEIVERS="com.zdwl.cation.ACION_CLEAN_ALL_RECEIVERS";

}
