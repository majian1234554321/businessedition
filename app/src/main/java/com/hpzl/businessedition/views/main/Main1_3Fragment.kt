package com.hpzl.businessedition.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.iview.Main1_1234View
import com.hpzl.businessedition.model.ReserveMainModel

/**
 *
 * @author admin
 * @date 2018/1/30
 */
class Main1_3Fragment : BaseFragment() , Main1_1234View {
    override fun setMain1_1234Data(t: ReserveMainModel, action: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TextView(inflater.context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}