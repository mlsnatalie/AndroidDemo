package com.example.lib

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    GlobalScope.launch {// 在后台启动一个新的协程并继续
        delay(1000L)// 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("hello world" + System.currentTimeMillis())
    }

    println("HELLO" + System.currentTimeMillis())
//    Thread.sleep(2000L)
    runBlocking {
        delay(2000L)
    }
}