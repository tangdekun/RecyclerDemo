package com.example.jhon.recyclerdemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.jhon.recyclerdemo.bean.JsonBean;
import com.example.jhon.recyclerdemo.bean.TypeBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.rest.RestService;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @RestService
    DataRest dataRest;
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.jhon.recyclerdemo", appContext.getPackageName());
    }
//    void prepareTypeData() {
//        Gson gson = new Gson();
//        String result = dataRest.getDateType();
//        Type type = new TypeToken<JsonBean<TypeBean>>(){}.getType();
//        JsonBean jsonResult = gson.fromJson(result,type);
//        if (jsonResult.getError_code()==0){
////            Toast("request data failed");
//        }
//        else{
//            TypeBean bean = (TypeBean) jsonResult.getResult();
//
//        }
//
//    }
}
