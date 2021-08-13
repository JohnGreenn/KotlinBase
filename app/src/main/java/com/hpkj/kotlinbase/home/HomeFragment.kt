package com.hpkj.kotlinbase.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hpkj.kotlinbase.R

/**
 * desc：
 * author：Glq
 * time：2021/08/12 9:32
 */
class HomeFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }






    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}