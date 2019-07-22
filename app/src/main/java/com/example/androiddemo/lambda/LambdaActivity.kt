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
            Person("新垣结衣", 17)
        )

        findTheOldest(person)
        findOldest(person)
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
        Log.e("oldest", person.maxBy { it.age }.toString())

    }
}

data class Person(var name: String, val age: Int)