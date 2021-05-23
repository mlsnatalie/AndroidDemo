package com.example.androiddemo.xiangxue.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.androiddemo.R;
import com.example.androiddemo.xiangxue.viewmodel.CustomViewModel;

/**
 * @author: mlsnatalie
 * @date: 2021/5/23 5:39 下午
 * @UpdateDate: 2021/5/23 5:39 下午
 * email：mlsnatalie@163.com
 * description：
 */
public class MainLiveDataActivity extends AppCompatActivity {
    private CustomViewModel mViewModel;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(CustomViewModel.class);
        final MutableLiveData<Integer> liveData = mViewModel.getLiveData();
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.e(TAG,"参数返回onCreate： " + integer);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MutableLiveData<Integer> liveData = mViewModel.getLiveData();
                liveData.observe(MainLiveDataActivity.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        Log.e(TAG,"参数返回onResume： " + integer);
                    }
                });
            }
        },5000);
    }
}
