package com.example.jhon.recyclerdemo;

import com.example.jhon.recyclerdemo.bean.ContentBean;
import com.example.jhon.recyclerdemo.bean.JsonBean;
import com.example.jhon.recyclerdemo.bean.JsonDataBean;
import com.example.jhon.recyclerdemo.consts.Const;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * Created by tangdekun on 2016/12/10.
 */
@Rest(rootUrl = Const.IP,converters = {StringHttpMessageConverter.class,GsonHttpMessageConverter.class})
public interface DataRest {
    @Get(Const.TYPE+"key="+Const.APP_KEY)
    String getDateType();
    //    http://japi.juhe.cn/funny/list.from?cat=5&st=0&count=20&key=您申请的key
    @Get(Const.QUERY_CONTENT_BY_TYPE+"key="+Const.APP_KEY+"&cat={cat}&st={st}&count={count}")
    ResponseEntity<JsonBean<JsonDataBean<ContentBean>>> getContent(int cat,int st,int count);



}
