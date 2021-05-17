package com.example.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.example.androiddemo.MyIntentService;
import com.example.androiddemo.R;

/**
 * @author: mlsnatalie
 * @date: 2021/5/10 9:59 AM
 * @UpdateDate: 2021/5/10 9:59 AM
 * email：mlsnatalie@163.com
 * description：
 */
public class IntentServiceActivity extends Activity implements MyIntentService.UpdateUI {

    /**
     * 图片地址集合
     */
    private String url[] = {
            "https://img-blog.csdn.net/20160903083245762",
            "https://img-blog.csdn.net/20160903083252184",
            "https://img-blog.csdn.net/20160903083257871",
            "https://img-blog.csdn.net/20160903083257871",
            "https://img-blog.csdn.net/20160903083311972",
            "https://img-blog.csdn.net/20160903083319668",
            "https://img-blog.csdn.net/20160903083326871"
    };

    private static ImageView imageView;
    private static final Handler mUIHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.e("aaaddd", Thread.currentThread().toString());//在主线程里
            imageView.setImageBitmap((Bitmap) msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        imageView = (ImageView) findViewById(R.id.image);

        /**
         * IntentService是异步线程。放入队列里面
         */
        Intent intent = new Intent(this,MyIntentService.class);
        for (int i=0;i<7;i++) {//循环启动任务
            intent.putExtra(MyIntentService.DOWNLOAD_URL,url[i]);
            intent.putExtra(MyIntentService.INDEX_FLAG,i);
            startService(intent);
        }
        MyIntentService.setUpdateUI(this);
    }

    //必须通过Handler去更新，该方法为异步方法，不可更新UI
    @Override
    public void updateUI(Message message) {
        mUIHandler.sendMessageDelayed(message,message.what * 1000);
    }
}
