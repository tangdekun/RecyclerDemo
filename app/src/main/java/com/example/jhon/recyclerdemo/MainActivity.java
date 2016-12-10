package com.example.jhon.recyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.jhon.recyclerdemo.adapter.TypeAdapter;
import com.example.jhon.recyclerdemo.bean.JsonBean;
import com.example.jhon.recyclerdemo.bean.TypeBean;
import com.example.jhon.recyclerdemo.bean.TypeData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.reflect.TypeToken.*;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @ViewById(R.id.type_recyclerview)
    RecyclerView type_recyclerview;
    @ViewById(R.id.content_recyclerview)
    RecyclerView content_recyclerview;
    @RestService
    DataRest dataRest;
    Gson gson;
    List<TypeData> mList;
    TypeAdapter mTypeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
        mList = new ArrayList<TypeData>();

    }
    @AfterViews
    void initView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        type_recyclerview.setLayoutManager(layoutManager);
        prepareTypeData();

    }

    @Background
     void prepareTypeData() {
        String result = dataRest.getDateType();
        Type type = new TypeToken<JsonBean<TypeBean>>(){}.getType();
        JsonBean<TypeBean> jsonResult = gson.fromJson(result,type);
        if (jsonResult.getError_code()!=0){
            Toast("request data failed");
        }
        else{
            TypeBean bean = (TypeBean) jsonResult.getResult();

            Map<String,String> dataMap = bean.getData().get(0);
            if (mList!=null&& mList.size()>0)
                mList.clear();
             TypeData mTypeData;
            for (int i = 0; i < dataMap.size(); i++) {
                mTypeData = new TypeData();
                mTypeData.setId(i+1);
                mTypeData.setName(dataMap.get(i+1+""));
                mList.add(mTypeData);
            }
            initRecyclerView(mList);

        }

    }


    @UiThread
    void Toast(String msg){
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT);
    }

    @UiThread
    void initRecyclerView(List<TypeData> typeDataList){
        mTypeAdapter = new TypeAdapter(typeDataList,MainActivity.this);
        type_recyclerview.setAdapter(mTypeAdapter);
    }

}
