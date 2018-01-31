package com.hpzl.businessedition.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseActivity
import com.hpzl.businessedition.views.login.LoginActivity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.internal.operators.completable.CompletableToFlowable
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)





        Flowable.timer(3, TimeUnit.SECONDS)
                .subscribe(Consumer {
                    Log.i("TAG", it.toString())
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                })
    }
}
