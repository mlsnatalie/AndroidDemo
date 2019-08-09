package com.example.androiddemo;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author Menglingshuai
 * @date 2019-07-26.
 * email：mlsnatalie@163.com
 * description：
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
