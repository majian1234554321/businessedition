package com.hpzl.businessedition.views.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.imp.TitleBarClickListener
import com.hpzl.businessedition.model.RoomTypeModel
import com.hpzl.businessedition.rx.RxBus
import kotlinx.android.synthetic.main.main2_1updatefragment.*

/**
 *
 * @author admin
 * @date 2018/2/2
 */
class Main2_1UpDateFragment : BaseFragment(), TitleBarClickListener {
    override fun setOnRightClickListener() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun setOnLeftClickListener() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        _mActivity.onBackPressed()
    }

    companion object {
        fun newInstance(objectValue: RoomTypeModel.ContentBean, position: Int): Main2_1UpDateFragment {
            val fragment = Main2_1UpDateFragment()
            val bundle = Bundle()
            bundle.putInt("postion", position)
            bundle.putParcelable("objectValue", objectValue)
            fragment.arguments = bundle
            return fragment
        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(mContext, R.layout.main2_1updatefragment, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tbv.setTitle("房型修改")
        tbv.setOnLeftClickListener(this)
        tv_update.setOnClickListener {
            et_price.text.trim().toString()
            val  intent =  Intent()
            intent.putExtra("key",et_price.text.trim().toString())
            intent.putExtra("name","Main2_1Fragment")
            RxBus.getDefault().post(intent)
            _mActivity.onBackPressed()


        }
        val bundle = arguments

        val objectValue = bundle?.getParcelable<RoomTypeModel.ContentBean>("objectValue")
        val postion = bundle?.getInt("postion")

        tv_housetype_name.text = "${objectValue?.name} (${objectValue?.mans}人)"
        tv_housetype_price.text = "${objectValue?.book_price} 元"
        iv_housetype.setImageResource(when (objectValue?.name) {
            "小包" -> {
                R.drawable.icon_baoxiang
            }
            "中包" -> {
                R.drawable.icon_baoxiang
            }
            "大包" -> {
                R.drawable.icon_baoxiang
            }
            "VIP包" -> {
                R.drawable.icon_vip
            }
            "卡座" -> {
                R.drawable.icon_kazuo
            }
            "台位" -> {
                R.drawable.icon_santai
            }
            else -> {
                R.drawable.icon_baoxiang
            }
        })
    }
}