package com.example.jhon.recyclerdemo.consts;

/**
 * Created by tangdekun on 2016/12/10.
 */

public class Const {

    /**
     * 聚合数据Key值
     */
    public  static final String APP_KEY = "9193eb75751f38de32e36caeaedaacf9";
    public  static final String IP = "http://japi.juhe.cn/funny/";
    /**
     * 获取笑话类型
     */
    public  static final String TYPE = "type.from?";
    /**
     * 按类型获取内容
     */
//    http://japi.juhe.cn/funny/list.from?cat=5&st=0&count=20&key=您申请的key
    public  static final String QUERY_CONTENT_BY_TYPE = "list.from?";
    /**
     * 按关键字获取内容
     */
//    http://japi.juhe.cn/funny/search.from?st=0&count=10&term=hi&key=您申请的key
    public  static final String QUERY_CONTENT_BY_KAYWORD = "search.from?";
    /**
     * 根据谜底id获取答案
     */
    //    http://japi.juhe.cn/funny/answer.from?id=109885&key=您申请的key
    public  static final String QUERY_ANSWER_BY_ID = "answer.from?";




}
