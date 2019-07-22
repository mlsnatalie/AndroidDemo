package com.example.androiddemo.lambda

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.androiddemo.R

/**
 * @author Menglingshuai
 * @date 2019-07-22.
 * email：mlsnatalie@163.com
 * description：
 */
class LambdaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambda)

        val person = listOf(
            Person("刘亦菲", 15),
            Person("苏菲玛索", 20),
            Person("花泽香菜", 21),
            Person("新垣结衣", 18)
        )

        findTheOldest(person)
        findOldest(person)
        filter(person)
        map(person)
        filterAndMap(person)
        all(person)
        any(person)
        find(person)
        indexOfFirst(person)
        groupBy(person)
        flatMap()
    }

    private fun findTheOldest(person: List<Person>) {
        var maxAge = 0
        var theOldest: Person? = null
        for (item in person) {
            if (item.age > maxAge) {
                maxAge = item.age
                theOldest = item
            }
        }
        Log.e("theOldest", theOldest.toString())
    }

    private fun findOldest(person: List<Person>) {
        val findOldest = person.maxBy { it.age }
        Log.e("oldest", findOldest.toString())

    }

    private fun filter(person: List<Person>) {
        val filter = person.filter { it.age % 2 == 0 }
        Log.e("filter", filter.toString())
    }

    private fun map(person: List<Person>) {
        val map = person.map { it.name }
        Log.e("map", map.toString())
    }

    private fun filterAndMap(person: List<Person>) {
        var filterMap = person.filter { it.age > 18 }.map { it.name }
        Log.e("filterMap", filterMap.toString())
    }

    //是否所有的人都小于等于20岁
    private fun all(person: List<Person>) {
        //判断一个人是否小于等于20岁
        val canBeInClub27 = { person: Person -> person.age <= 20 }
        //判断person中所有元素是不是都小于等于20岁
//        val personLessTwenty = person.all(canBeInClub27)
        val personLessTwenty = person.all { it.age <= 20 }
        Log.e("all", personLessTwenty.toString())
    }

    //是否有一个人小于等于20岁
    private fun any(person: List<Person>) {
        val personLessTwenty = person.any { it.age <= 20 }
        Log.e("any", personLessTwenty.toString())
    }

    //要找到一个满足判断式的元素，使用find函数：
    private fun find(person: List<Person>) {
        val current = person.find { it.age == 21 }
        Log.e("find", current.toString())
    }

    //要找到第一个满足函数的数组下标
    private fun indexOfFirst(person: List<Person>) {
        val index = person.indexOfFirst { it.age == 18 }
        if (index == -1) {
            Log.e("indexOfFirst", "没有找到")
        } else {
            Log.e("indexOfFirst", index.toString())
        }
    }

    //groupBy：把列表转换成分组的map
    private fun groupBy(person: List<Person>) {
        val current = person.groupBy { it.name }
        println("groupBy$current")
    }

    //把两个集合合并成一个
    private fun flatMap() {
        val strings = listOf("abc", "def")
        val current = strings.flatMap { it.toList() }
        println("flatMap$current")
    }

}

data class Person(var name: String, var age: Int)