package com.hpkj.kotlinbase.main

import android.content.Context
import android.content.Intent
import android.view.KeyEvent
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hjq.toast.ToastUtils
import com.hpkj.core.view.base.BaseActivity
import com.hpkj.kotlinbase.R
import com.hpkj.kotlinbase.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()


    override fun getLayoutView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        binding.homeView?.init(supportFragmentManager, viewModel)
    }


    override fun initData() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        exitProcess(0)
    }

    private var exitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit()
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun exit() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            ToastUtils.show(getString(R.string.exit_app))
            exitTime = System.currentTimeMillis()
        } else {
            exitProcess(0)
        }
    }

    companion object {
        const val TAG = "MainActivity"

        fun actionStart(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

}