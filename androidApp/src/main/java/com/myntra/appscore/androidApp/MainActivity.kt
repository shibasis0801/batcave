package com.myntra.appscore.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.TextView
import com.myntra.appscore.database.Greeting
import com.myntra.appscore.database.SQLDatabase
import com.myntra.appscore.database.createDriver
import com.myntra.appscore.database.runQuery

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
        Log.d("", "SHIBASIS")
        val driver = createDriver(this)
        val database = SQLDatabase(driver)
        runQuery(database)
    }
}
