package com.hpkj.kotlinbase.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hpkj.kotlinbase.R
import com.hpkj.kotlinbase.databinding.FragmentCategoryBinding

/**
 * desc：
 * author：Glq
 * time：2021/08/13 10:09
 */
class CategoryFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }




    companion object {
        @JvmStatic
        fun newInstance() = CategoryFragment()
    }
}