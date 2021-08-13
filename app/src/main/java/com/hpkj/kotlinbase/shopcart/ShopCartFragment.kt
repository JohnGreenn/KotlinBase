package com.hpkj.kotlinbase.shopcart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hpkj.kotlinbase.R

/**
 * desc：
 * author：Glq
 * time：2021/08/13 11:13
 */
class ShopCartFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_cart, container, false)
    }




    companion object {
        @JvmStatic
        fun newInstance() = ShopCartFragment()
    }
}