package com.hpkj.core.view.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

/**
 * desc：Activity基类
 * author：Glq
 * time：2021/08/10 17:33
 */
abstract class BaseActivity : AppCompatActivity(), BaseActivityInit{

    /**
     * Activity中显示加载等待的控件。
     */
    private var loading: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutView())
        initView()
        initData()
    }

    override fun initData() {
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
        //setupViews()
    }
}