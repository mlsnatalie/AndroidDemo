package com.example.androiddemo.xiangxue.viewmodel;

import android.os.SystemClock;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {
    MutableLiveData<Integer> mLiveData;
    private int mPostedValue = 10;
    public MutableLiveData<Integer> getLiveData(){
        if(mLiveData == null){
            mLiveData = new MutableLiveData<>();
        }
        loadData();
        return mLiveData;
    }

    private void loadData() {
        new Thread(){
            @Override
            public void run() {
                SystemClock.sleep(2000);
                mLiveData.postValue(mPostedValue);
                mPostedValue = mPostedValue * 2;
            }
        }.start();
    }
}