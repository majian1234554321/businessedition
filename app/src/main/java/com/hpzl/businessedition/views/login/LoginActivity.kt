package com.hpzl.businessedition.views.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportFragmentManager.beginTransaction().replace(R.id.framelayout, LoginFragment()).commit()
    }

    fun showFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().add(R.id.framelayout, fragment).addToBackStack("").commit()
    }
}
