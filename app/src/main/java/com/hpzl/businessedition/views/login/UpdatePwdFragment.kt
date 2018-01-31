package com.hpzl.businessedition.views.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.presenter.UpdatePwdPresent
import kotlinx.android.synthetic.main.updatepwdfragment.*

/**
 *
 * @author admin
 * @date 2018/1/29
 */
class UpdatePwdFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_commit -> {
            }
            R.id.tv_code -> {
                if (!TextUtils.isEmpty(let1.getRightTitle())) {
                    UpdatePwdPresent().verifyCode(let1.getRightTitle())
                } else {
                    toast("请输入手机号")
                }
            }
            else -> {
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return View.inflate(inflater.context, R.layout.updatepwdfragment, null)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tbv.setTitle("找回密码")
        let1.setValues("手机号", "请输入手机号")
        let2.setValues("验证码", "请输入验证码")
        let3.setValues("新密码", "请输入密码")
        let4.setValues("确认密码", "请确认密码")

        btn_commit.setOnClickListener(this)
        tv_code.setOnClickListener(this)


    }
}