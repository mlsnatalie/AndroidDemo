package com.example.androiddemo.jetPack

import android.content.Context
import android.database.DatabaseUtils
import android.location.Location
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.bumptech.glide.Glide
import com.example.androiddemo.R
import com.example.androiddemo.databinding.ActivityNewJetpackBinding

/**
 * @author: mlsnatalie
 * @date: 2020/11/24 7:58 PM
 * @UpdateDate: 2020/11/24 7:58 PM
 * email：mlsnatalie@163.com
 * description：
 */
class NewJetPackActivity : AppCompatActivity() {

    private val userModel: UserModel by viewModels()
    private lateinit var myLayoutLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewJetpackBinding = ActivityNewJetpackBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val binding: ActivityNewJetpackBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_jetpack)
//        binding.user = User("xys", "")
        binding.viewmodel = userModel
        binding.lifecycleOwner = this

        myLayoutLocationListener = MyLocationListener(this) {
            location -> {}
        }

        lifecycle.addObserver(myLayoutLocationListener)
    }

    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(this)
            .load(url)
            .into(view)
    }

    internal class MyLocationListener(private val context: Context, private val callback: (Location) -> Unit): LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun start() {}

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun stop() {}
    }
}