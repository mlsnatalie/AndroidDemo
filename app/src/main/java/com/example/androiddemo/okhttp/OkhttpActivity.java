package com.example.androiddemo.okhttp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddemo.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {

    private Call call;
    private TextView tv_internet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        initOkhttp();
        tv_internet = findViewById(R.id.tv_internet);

        new Thread(new Runnable() {
            @Override
            public void run() {
                synRequest();
                asyRequest();
            }
        }).start();
    }

    private void initOkhttp() {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();

        Request request = new Request.Builder().url("http://www.baidu.com").get().build();
        call = client.newCall(request);
    }


    private void synRequest() {

        try {
            Response response = call.execute();
            Log.e("aaaddd", "同步请求模式" + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void asyRequest() {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("aaaddd", "fail");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("aaaddd", "异步请求" + response.body().string());

            }
        });
    }

}
