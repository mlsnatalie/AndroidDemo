package com.example.androiddemo.xiangxue.api;


import com.example.androiddemo.http.BaseResponse;
import com.example.androiddemo.xiangxue.bean.ProjectBean;
import com.example.androiddemo.xiangxue.bean.ProjectItem;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author: mlsnatalie
 * @date: 2021/3/9 4:57 PM
 * @UpdateDate: 2021/3/9 4:57 PM
 * email：mlsnatalie@163.com
 * description：
 */
public interface WanAndroidApi {

    @GET("/project/tree/json")
    Observable<ProjectBean> getProject();

    @GET("/project/list/{page}/json")
    Observable<ProjectItem> getProjectItem(@Path("page") int page, @Query("cid") int cid);

    @POST("/user/register")
    @FormUrlEncoded
    Observable<BaseResponse> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    @POST("/user/login")
    @FormUrlEncoded
    Observable<BaseResponse> login(@Field("username") String username, @Field("password") String password);
}
