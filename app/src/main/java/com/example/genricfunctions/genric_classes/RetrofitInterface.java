package com.example.genricfunctions.genric_classes;

import com.example.genricfunctions.ModelClass;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @FormUrlEncoded
    @POST("getDataAPI")
    Call<ModelClass> getQuestion(@FieldMap WeakHashMap<String, String> questionDetails);
}
