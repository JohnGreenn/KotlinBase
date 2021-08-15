package com.hpkj.kotlinbase.utils

import android.content.Context
import android.widget.Toast
import com.hpkj.kotlinbase.App

fun String.showToast(
    duration: Int = Toast.LENGTH_SHORT
) {
    try {
        Toast.makeText(App.context, this, duration).show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Int.showToast(
    duration: Int = Toast.LENGTH_SHORT
) {
    try {
        Toast.makeText(App.context, this, duration).show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}