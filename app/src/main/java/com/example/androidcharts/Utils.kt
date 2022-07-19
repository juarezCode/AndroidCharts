package com.example.androidcharts

import android.content.Context
import androidx.core.content.ContextCompat

object Utils {

    fun getColors(context: Context): List<Int> {
        return listOf(
            ContextCompat.getColor(context, R.color.UDNItalika),
            ContextCompat.getColor(context, R.color.UDNRedUnica),
            ContextCompat.getColor(context, R.color.UDNFA),
            ContextCompat.getColor(context, R.color.UDNUnknown),
            ContextCompat.getColor(context, R.color.UDNDial),
            ContextCompat.getColor(context, R.color.UDNTVAzteca),
            ContextCompat.getColor(context, R.color.UDNBaz),
            ContextCompat.getColor(context, R.color.UDNBancoAzteca),
            ContextCompat.getColor(context, R.color.UDNHero),
            ContextCompat.getColor(context, R.color.UDNNeto),
            ContextCompat.getColor(context, R.color.UDNBaz),
            ContextCompat.getColor(context, R.color.UDNTotalPlay),
        )
    }
}