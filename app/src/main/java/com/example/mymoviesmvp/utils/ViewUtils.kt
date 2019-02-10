package com.example.mymoviesmvp.utils

import android.content.Context
import android.graphics.Point
import android.view.WindowManager

object ViewUtils {
    @JvmStatic
    fun getScreenHeight(context: Context): Int {

        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)

        return size.y
    }

    @JvmStatic
    fun getScreenWidth(context: Context): Int {

        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)

        return size.x
    }
}