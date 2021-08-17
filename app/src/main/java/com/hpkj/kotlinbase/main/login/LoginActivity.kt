package com.hpkj.kotlinbase.main.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hpkj.core.base.BaseActivity
import com.hpkj.kotlinbase.R
import com.hpkj.kotlinbase.databinding.ActivityLoginBinding


class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun getLayoutView(): View {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        binding.btnLogin.setOnClickListener(this)

    }




    override fun onClick(v: View?) {

    }
}