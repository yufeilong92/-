package com.example.administrator.zhbj.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 * 新闻列表页面的数据
 * 碰到{}创建类
 * 碰到[创建集合
 * 类的变量高度一致
 */
public class NewListData {
    /**
     * countcommenturl : http://zhbj.qianlong.com/client/content/countComment/
     * more : /10008/list_2.json
     * news : [{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35311,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35312,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35313,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35314,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35316,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35310,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35318,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35314","id":35314,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:54","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35117","id":35117,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 08:45","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"}]
     * title : 鍥介檯
     * topic : [{"description":"11111111","id":10101,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","sort":1,"title":"鍥介檯","url":"http://10.0.2.2:8080/zhbj/10008/list_1.json"},{"description":"22222222","id":10100,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","sort":2,"title":"222222222222","url":"http://10.0.2.2:8080/zhbj/10008/list_1.json"}]
     * topnews : [{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35301,"pubdate":"2014-04-08 14:24","title":"鍥介檯1","topimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35125","id":35125,"pubdate":"2014-04-08 09:09","title":"鍥介檯2","topimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU92.jpg","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"}]
     */

    private DataBean data;
    /**
     * data : {"countcommenturl":"http://zhbj.qianlong.com/client/content/countComment/","more":"/10008/list_2.json","news":[{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35311,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35312,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35313,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35314,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35315,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35316,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35310,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35319","id":35318,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:58","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35314","id":35314,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 14:54","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35117","id":35117,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","pubdate":"2014-04-08 08:45","title":"鍥介檯","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"}],"title":"鍥介檯","topic":[{"description":"11111111","id":10101,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","sort":1,"title":"鍥介檯","url":"http://10.0.2.2:8080/zhbj/10008/list_1.json"},{"description":"22222222","id":10100,"listimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","sort":2,"title":"222222222222","url":"http://10.0.2.2:8080/zhbj/10008/list_1.json"}],"topnews":[{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35301","id":35301,"pubdate":"2014-04-08 14:24","title":"鍥介檯1","topimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"},{"comment":true,"commentlist":"http://10.0.2.2:8080/zhbj/10008/comment_1.json","commenturl":"http://zhbj.qianlong.com/client/user/newComment/35125","id":35125,"pubdate":"2014-04-08 09:09","title":"鍥介檯2","topimage":"http://10.0.2.2:8080/zhbj/10008/1452327318UU92.jpg","type":"news","url":"http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html"}]}
     * retcode : 200
     */

    private int retcode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    @Override
    public String toString() {
        return "NewListData{" +
                "data=" + data +
                ", retcode=" + retcode +
                '}';
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "countcommenturl='" + countcommenturl + '\'' +
                    ", more='" + more + '\'' +
                    ", title='" + title + '\'' +
                    ", news=" + news +
                    ", topic=" + topic +
                    ", topnews=" + topnews +
                    '}';
        }

        private String countcommenturl;
        private String more;
        private String title;
        /**
         * comment : true
         * commentlist : http://10.0.2.2:8080/zhbj/10008/comment_1.json
         * commenturl : http://zhbj.qianlong.com/client/user/newComment/35319
         * id : 35311
         * listimage : http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg
         * pubdate : 2014-04-08 14:58
         * title : 鍥介檯
         * type : news
         * url : http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html
         */

        private List<NewsBean> news;
        /**
         * description : 11111111
         * id : 10101
         * listimage : http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg
         * sort : 1
         * title : 鍥介檯
         * url : http://10.0.2.2:8080/zhbj/10008/list_1.json
         */

        private List<TopicBean> topic;
        /**
         * comment : true
         * commentlist : http://10.0.2.2:8080/zhbj/10008/comment_1.json
         * commenturl : http://zhbj.qianlong.com/client/user/newComment/35301
         * id : 35301
         * pubdate : 2014-04-08 14:24
         * title : 鍥介檯1
         * topimage : http://10.0.2.2:8080/zhbj/10008/1452327318UU91.jpg
         * type : news
         * url : http://10.0.2.2:8080/zhbj/10008/724D6A55496A11726628.html
         */

        private List<TopnewsBean> topnews;

        public String getCountcommenturl() {
            return countcommenturl;
        }

        public void setCountcommenturl(String countcommenturl) {
            this.countcommenturl = countcommenturl;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<TopicBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicBean> topic) {
            this.topic = topic;
        }

        public List<TopnewsBean> getTopnews() {
            return topnews;
        }

        public void setTopnews(List<TopnewsBean> topnews) {
            this.topnews = topnews;
        }

        public static class NewsBean {
            @Override
            public String toString() {
                return "NewsBean{" +
                        "comment=" + comment +
                        ", commentlist='" + commentlist + '\'' +
                        ", commenturl='" + commenturl + '\'' +
                        ", id=" + id +
                        ", listimage='" + listimage + '\'' +
                        ", pubdate='" + pubdate + '\'' +
                        ", title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String listimage;
            private String pubdate;
            private String title;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TopicBean {
            @Override
            public String toString() {
                return "TopicBean{" +
                        "description='" + description + '\'' +
                        ", id=" + id +
                        ", listimage='" + listimage + '\'' +
                        ", sort=" + sort +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            private String description;
            private int id;
            private String listimage;
            private int sort;
            private String title;
            private String url;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TopnewsBean {
            @Override
            public String toString() {
                return "TopnewsBean{" +
                        "comment=" + comment +
                        ", commentlist='" + commentlist + '\'' +
                        ", commenturl='" + commenturl + '\'' +
                        ", id=" + id +
                        ", pubdate='" + pubdate + '\'' +
                        ", title='" + title + '\'' +
                        ", topimage='" + topimage + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            private boolean comment;
            private String commentlist;
            private String commenturl;
            private int id;
            private String pubdate;
            private String title;
            private String topimage;
            private String type;
            private String url;

            public boolean isComment() {
                return comment;
            }

            public void setComment(boolean comment) {
                this.comment = comment;
            }

            public String getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
            }

            public String getCommenturl() {
                return commenturl;
            }

            public void setCommenturl(String commenturl) {
                this.commenturl = commenturl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTopimage() {
                return topimage;
            }

            public void setTopimage(String topimage) {
                this.topimage = topimage;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
//    public NewsData data;
//    public int reccode;
//
//    /**
//     * 新闻数据
//     */
//    public  static  class NewsData
//    {
//        public  String countcommenturl;
//        public String title;
//        public String more;
//        public String topic;
//        public String topnews;
//        public List<>news =new ArrayList<>();
//        public List<> topic=new ArrayList<>();
//        public  List<> topnews=new ArrayList<>();
//    }
//    public static class NewItem{
//        public boolean comment;
//        public String commentlist;
//        public String commenturl;
//        public int id;
//    }

}
