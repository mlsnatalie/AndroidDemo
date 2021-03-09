package com.example.androiddemo.http;

import android.util.Log;

import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: mlsnatalie
 * @date: 2021/3/9 5:01 PM
 * @UpdateDate: 2021/3/9 5:01 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class HttpUtils {


    public static String BASE_URL = "https://www.wanandroid.com/";

    public static class HttpLogger implements HttpLoggingInterceptor.Logger {

        private StringBuilder mMessage = new StringBuilder();

        @Override
        public void log(String message) {
            // 请求或者响应开始
            if (message.startsWith("--> POST")) {
                mMessage.setLength(0);
            }
            // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
            boolean isJson = (message.startsWith("{") && message.endsWith("}"))
                    || (message.startsWith("[") && message.endsWith("]"));
            if (isJson) {
                message = JsonUtil.formatJson(message);
            }
            mMessage.append(message.concat("\n"));
            // 请求或者响应结束，打印整条日志
            if (message.startsWith("<-- END HTTP")) {
                Log.d( "Zero",mMessage.toString());
            }
        }
    }


    public static Retrofit getOnlineCookieRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpBuild = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = httpBuild
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.SECONDS)
                .writeTimeout(1000, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                //添加一个json解析的工具
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                //添加rxjava的工具
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
