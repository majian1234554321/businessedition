package com.hpzl.businessedition.views


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.MenuItem
import com.hpzl.businessedition.R
import com.hpzl.businessedition.base.BaseActivity
import com.hpzl.businessedition.base.BaseFragment
import com.hpzl.businessedition.utils.BottomNavigationViewHelper
import com.hpzl.businessedition.views.main.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        when (item.itemId) {
            R.id.main1 -> {
                replaceFragment(Main1Fragment(), R.id.display)
                return true
            }
            R.id.main2 -> {
                replaceFragment(Main2Fragment(), R.id.display)
                return true
            }
            R.id.main3 -> {
                replaceFragment(Main3Fragment(), R.id.display)
                return true
            }
            R.id.main4 -> {
                replaceFragment(Main4Fragment(), R.id.display)
                return true
            }
            R.id.main5 -> {
                replaceFragment(Main5Fragment(), R.id.display)
                return true
            }
            else -> {
            }
        }
        return false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BottomNavigationViewHelper.disableShiftMode(bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        bottom_navigation.selectedItemId = 0

        val list = mutableListOf<BaseFragment>()
        list.addElement(Main1Fragment())
                .addElement(Main2Fragment()).addElement(Main3Fragment()).addElement(Main4Fragment()).addElement(Main5Fragment())
        replaceFragment(Main1Fragment(), R.id.display)

    }

    fun MutableList<BaseFragment>.addElement(fragment: BaseFragment): MutableList<BaseFragment> {
        add(fragment)
        return this
    }
}
