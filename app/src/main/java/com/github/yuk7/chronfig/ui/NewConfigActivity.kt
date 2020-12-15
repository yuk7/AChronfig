package com.github.yuk7.chronfig.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.yuk7.chronfig.R
import com.github.yuk7.chronfig.ui.editor.EditorFragment

class NewConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment,
                EditorFragment()
        ).commit()
    }
}