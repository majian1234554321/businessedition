package com.hpzl.businessedition.base


import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment

import android.support.v7.app.AlertDialog


import android.view.MotionEvent


import com.hpzl.businessedition.utils.SPUtils
import com.hpzl.businessedition.views.login.LoginActivity
import me.yokeyword.fragmentation.*
import me.yokeyword.fragmentation.anim.FragmentAnimator


abstract class BaseActivity : SupportActivity(), ISupportActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    fun replaceFragment(fragment: Fragment, id: Int) {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }

    /**
     * 提示是否重新登录
     */
    fun alertReSignIn() {


        AlertDialog.Builder(this).setTitle("提示")
                .setMessage("您的账号在其他的地方登录了" +
                        "是否重新登录？").setNegativeButton("确认",
                DialogInterface.OnClickListener { dialog, which ->
                    startActivity(Intent(this, LoginActivity::class.java))
                    SPUtils.removeKey("token")
                }
        ).show().setCanceledOnTouchOutside(false)


        /* mSPUtils.removeUser()
         mSPUtils.removeKey(Constants.IS_SIGN_IN)*/
    }




}
