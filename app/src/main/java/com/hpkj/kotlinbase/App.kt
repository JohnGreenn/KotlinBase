package com.hpkj.kotlinbase

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.tencent.smtt.sdk.QbSdk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*
import kotlin.system.exitProcess

/**
 * desc：
 * author：Glq
 * time：2021/08/10 15:52
 */
class App : Application() {
    //所有活动集合
    private var activityLinkedList = LinkedList<Activity>()

    override fun onCreate() {
        super.onCreate()

        instances = this
        context = applicationContext

        initSdk()
    }

    private fun initSdk() {
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            initQbSdk()
            initBugLy()
        }
    }



    private fun initQbSdk() {
        // x5内核初始化接口
        QbSdk.initX5Environment(applicationContext, object : QbSdk.PreInitCallback {
            override fun onViewInitFinished(arg0: Boolean) { //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("APP", " onViewInitFinished is $arg0")
            }

            override fun onCoreInitFinished() {
                Log.e("APP", " onCoreInitFinished")
            }
        })
    }

    private fun initBugLy() {
        // Bugly bug上报
    }

    /**
     * 将所有类退出栈
     */
    fun exit() {
        try {
            for (i in activityLinkedList.indices) {
                activityLinkedList[i].finish()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(0)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instances: App? = null

        //全局context
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun getInstance(): App {
            if (instances == null) {
                synchronized(App::class.java) {
                    if (instances == null) {
                        instances = App()
                    }
                }
            }
            return instances!!
        }

        //static 代码段可以防止内存泄露
        init { //设置全局的Header构建器
            //设置全局的Header构建器
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
                layout.setPrimaryColorsId(
                    R.color.refresh,
                    R.color.text_color
                )//全局设置主题颜色  CustomRefreshHeader   ClassicsHeader
                ClassicsHeader(context)//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
            //设置全局的Footer构建器
            SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
                //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter(context).setDrawableSize(20f)
            }
        }
    }


}