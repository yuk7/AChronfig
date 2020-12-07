package com.github.yuk7.chronfig.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.yuk7.chronfig.R
import com.github.yuk7.chronfig.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment,
            MainFragment()
        ).commit()
    }
}