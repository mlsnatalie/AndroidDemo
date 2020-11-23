package com.example.androiddemo.activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.androiddemo.MainActivity
import com.example.androiddemo.R
import kotlinx.android.synthetic.main.activity_notification.*


/**
 * @author: mlsnatalie
 * @date: 2020/11/23 2:07 PM
 * @UpdateDate: 2020/11/23 2:07 PM
 * email：mlsnatalie@163.com
 * description：
 */
class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        button_notification.setOnClickListener {
//            openNormalNotification() //打开普通通知栏
            openRemoteViewNotification() //
        }
    }

    private fun openNormalNotification() {
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //8.0 以后需要加上channelId 才能正常显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "default"
            val channelName = "默认通知"
            manager.createNotificationChannel(NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH))
        }
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, "default")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85"))
        val pendingIntent = PendingIntent.getActivities(this, 0, arrayOf(intent), 0)
        val notification = builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setContentTitle("普通通知")
                .build()
        manager.notify(1, notification)


//        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//        //8.0 以后需要加上channelId 才能正常显示
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channelId = "default"
//            val channelName = "默认通知"
//            manager.createNotificationChannel(NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH))
//        }
//        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, "default")
//        val notification = builder
//                .setContentTitle("这是通知标题")
//                .setContentText("这是通知内容")
//                .setWhen(System.currentTimeMillis())
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
//                .setColor(Color.parseColor("#EAA935"))
//                .build()
//        manager.notify(1, notification)
    }

    private fun openRemoteViewNotification() {
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //8.0 以后需要加上channelId 才能正常显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "default"
            val channelName = "默认通知"
            manager.createNotificationChannel(NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH))
        }
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, "default")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85"))
        val pendingIntent = PendingIntent.getActivities(this, 0, arrayOf(intent), 0)
        val notification = builder.setContentIntent(pendingIntent)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .setAutoCancel(true)
            .setContentTitle("普通通知")
            .build()

        val remoteViews = RemoteViews(packageName, R.layout.layout_notification_new)
        remoteViews.setTextViewText(1, "chapter_5: ")
        remoteViews.setImageViewResource(R.id.icon, R.mipmap.ic_launcher)
        val openActivity2PendingIntent = PendingIntent.getActivity(this,
                0, Intent(this, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT)
        remoteViews.setOnClickPendingIntent(R.id.open_activity2, openActivity2PendingIntent)
        notification.contentView = remoteViews
        notification.contentIntent = pendingIntent
        manager.notify(1, notification)
    }

}