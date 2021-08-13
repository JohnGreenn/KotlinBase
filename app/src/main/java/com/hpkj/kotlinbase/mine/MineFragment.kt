package com.hpkj.kotlinbase.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hpkj.kotlinbase.R

/**
 * desc：我的页面
 * author：Glq
 * time：2021/08/12 9:48
 */
class MineFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }






    companion object {
        @JvmStatic
        fun newInstance() = MineFragment()
    }
}