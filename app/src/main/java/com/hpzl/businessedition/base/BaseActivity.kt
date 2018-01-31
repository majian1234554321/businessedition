package com.hpzl.businessedition.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.hpzl.businessedition.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

    }

    fun replaceFragment(fragment: Fragment, id: Int) {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }
}
