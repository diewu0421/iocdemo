package com.example.java_apt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ioc.Bind
import com.example.ioc.ZlwAno

@ZlwAno(2)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
