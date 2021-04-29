package com.example.androiddemo

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.androiddemo.xiangxue.demo.observer.Observable
import com.example.androiddemo.xiangxue.demo.observer.Observer
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.androiddemo", appContext.packageName)
        myTest()
    }

    private fun myTest() {
        // write your code here
//        MObservable mObservable = new MObservable();
//        MObserver mObserver = new MObserver("小双");
//
//        mObservable.add(mObserver);
//        mObserver.update("开启通知");


        //观察者模式

        // write your code here
//        MObservable mObservable = new MObservable();
//        MObserver mObserver = new MObserver("小双");
//
//        mObservable.add(mObserver);
//        mObserver.update("开启通知");


        //观察者模式
        Observable.create<String> { emitter ->
            emitter.onNext("谢义双发送消息：")
        }
            .map { s ->
                s + "网络连接成功++"
            }
            .map { s ->
                s + "数据库连接成功++"
            }.map { s ->
                s + "文件系统连接成功++"
            }.map { s ->
                println("上游：" + Thread.currentThread().name)
                s + "可以登录++"
            }
            .subscribeOn()
            .observerOn()
            .subscribe(object : Observer<String?> {
                override fun onSubscribe() {
                    println("订阅：" + Thread.currentThread().name)
                }

                override fun onNext(s: String?) {
                    println("下游：" + Thread.currentThread().name)
                    println("收到消息：" + s as String?)
                }

                override fun onError(throwable: Throwable) {}
                override fun onComplete() {}
            })

        //装饰器模式
//        Pizza x = new BasePizza();
//        PizzaA p = new PizzaA(new PizzaB(new PizzaC(x)));
//        p.show();
    }
}
