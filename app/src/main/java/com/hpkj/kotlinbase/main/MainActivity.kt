package com.hpkj.kotlinbase.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.hpkj.core.view.base.BaseActivity
import com.hpkj.kotlinbase.R
import com.hpkj.kotlinbase.databinding.ActivityMainBinding
import com.hpkj.kotlinbase.utils.LogUtil
import com.hpkj.kotlinbase.utils.showToast
import kotlin.system.exitProcess

class MainActivity :BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var navController: NavController

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val rootView: View = binding.root
//        setContentView(rootView)
//        initBottom()
//
//    }

    override fun getLayoutView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        //binding.homeView?.init(supportFragmentManager, viewModel)
        initBottom()
    }

    private fun initBottom() {

        // (1)初始化 navController,
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        navController = navHostFragment.navController

        // (2)关联 “底部导航栏”与“navController”, 导航路由见 app/src/main/res/navigation/nav_graph.xml
        binding.bottomNavigationView.setupWithNavController(navController)

        // 不使用图标默认变色
        binding.bottomNavigationView.itemIconTintList = null


    }

    override fun onSupportNavigateUp(): Boolean {
        LogUtil.e(TAG, "onSupportNavigateUp: ")
        return navController.navigateUp()
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
            R.string.exit_app.showToast(Toast.LENGTH_LONG)
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