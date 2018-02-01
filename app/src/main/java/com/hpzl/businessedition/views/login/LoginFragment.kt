package com.hpzl.businessedition.views.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseApp
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.iview.LoginView
import com.hpzl.businessedition.presenter.LoginPresenter
import com.hpzl.businessedition.utils.SPUtils
import com.hpzl.businessedition.views.MainActivity
import kotlinx.android.synthetic.main.loginfragment.*

/**
 *
 * @author admin
 * @date 2018/1/29
 */
class LoginFragment : Fragment(), View.OnClickListener, LoginView {
    override fun setData() {


        startActivity(Intent(BaseApp.instance, MainActivity::class.java))
        (this@LoginFragment.activity as LoginActivity).finish()
    }

    override fun onClick(v: View?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when (v!!.id) {
            R.id.tv_signin_forget_pwd -> {

                val loginActivity = this@LoginFragment.activity as LoginActivity
                loginActivity.showFragment(UpdatePwdFragment())
            }
            R.id.ivclose -> {

            }

            R.id.tv_signin_register -> {
                val loginActivity = this@LoginFragment.activity as LoginActivity
                loginActivity.showFragment(RegisterFragment())
            }

            R.id.btn_signin -> {

                if (!TextUtils.isEmpty(SPUtils.getString("token", ""))) {
                    startActivity(Intent(BaseApp.instance, MainActivity::class.java))
                    (this@LoginFragment.activity as LoginActivity).finish()
                } else {
                    val loginPresenter = LoginPresenter(BaseApp.instance, this)
                    //    loginPresenter.login(et_signin_mobile.text.trim().toString(),et_signin_password.text.toString().trim(),"12233","android")
                    loginPresenter.login("13668018462", "123456", "12233", "android")
                }


            }

            else -> {
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return View.inflate(inflater.context, R.layout.loginfragment, null)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_signin_forget_pwd.setOnClickListener(this)
        ivclose.setOnClickListener(this)
        tv_signin_register.setOnClickListener(this)
        btn_signin.setOnClickListener(this)
    }
}