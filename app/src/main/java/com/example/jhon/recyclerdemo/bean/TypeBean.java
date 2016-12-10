package com.example.jhon.recyclerdemo.bean;

import org.json.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * Created by tangdekun on 2016/12/10.
 */

public class TypeBean {
    public List<Map<String, String>> getData() {
        return data;
    }

    public void setData(List<Map<String, String>> data) {
        this.data = data;
    }

    private List<Map<String,String>> data;

}
