package com.intelligent.ratingdialog

import android.content.Context
import android.content.SharedPreferences

class OptionManager {
    var CUSTOM_TITLE_KEY = "CUSTOM_TITLE_KEY"
    var CUSTOM_DESC_KEY = "CUSTOM_DESC_KEY"
    var CUSTOM_RATE_KEY = "CUSTOM_RATE_KEY"
    var CUSTOM_LATER_KEY = "CUSTOM_LATER_KEY"
    var CUSTOM_NEVER_KEY = "CUSTOM_NEVER_KEY"
    var TIMES_USED_KEY = "TIMES_USED_KEY"
    var THRESHOLD_KEY = "THRESHOLD_KEY"
    var NEVER_ASK_AGAIN_KEY = "NEVER_ASK_AGAIN"


    fun getSharedPref(context: Context):SharedPreferences{
        return context.getSharedPreferences("mypref",Context.MODE_PRIVATE)
    }


    fun setNeverAskAgain(context: Context,option: Boolean){
        var sp = getSharedPref(context)
        sp.edit().putBoolean(NEVER_ASK_AGAIN_KEY,option).apply()
    }
    fun getNeverAskAgain(context: Context): Boolean{
        var sp = getSharedPref(context)
        return sp.getBoolean(NEVER_ASK_AGAIN_KEY,false)
    }

    fun setTitle(context: Context,title:String){
        var sp = getSharedPref(context)
        sp.edit().putString(CUSTOM_TITLE_KEY,title).apply()
    }
    fun getTitle(context: Context):String{
        var sp = getSharedPref(context)
        return sp.getString(CUSTOM_TITLE_KEY,""+context.resources.getString(R.string.dialog_title)).toString()
    }

    fun setDescription(context: Context,desc:String){
        var sp = getSharedPref(context)
        sp.edit().putString(CUSTOM_DESC_KEY,desc).apply()
    }
    fun getDescription(context: Context):String{
        var sp = getSharedPref(context)
        return sp.getString(CUSTOM_DESC_KEY,""+context.resources.getString(R.string.dialog_description)).toString()
    }

    fun setRateTitle(context: Context,title:String){
        var sp = getSharedPref(context)
        sp.edit().putString(CUSTOM_RATE_KEY,title).apply()
    }
    fun getRateTitle(context: Context):String{
        var sp = getSharedPref(context)
        return sp.getString(CUSTOM_RATE_KEY,""+context.resources.getString(R.string.rate_title)).toString()
    }

    fun setLaterTitle(context: Context,title:String){
        var sp = getSharedPref(context)
        sp.edit().putString(CUSTOM_LATER_KEY,title).apply()
    }
    fun getLaterTitle(context: Context):String{
        var sp = getSharedPref(context)
        return sp.getString(CUSTOM_LATER_KEY,""+context.resources.getString(R.string.later_title)).toString()
    }

    fun setNeverTitle(context: Context,title:String){
        var sp = getSharedPref(context)
        sp.edit().putString(CUSTOM_NEVER_KEY,title).apply()
    }
    fun getNeverTitle(context: Context):String{
        var sp = getSharedPref(context)
        return sp.getString(CUSTOM_NEVER_KEY,""+context.resources.getString(R.string.never_title)).toString()
    }

    fun getTimesUsed(context: Context): Int{
        var sp = getSharedPref(context)
        return sp.getInt(TIMES_USED_KEY,0)
    }
    fun increaseTimesUsed(context: Context){
        var sp = getSharedPref(context)
        var timesUsed = sp.getInt(TIMES_USED_KEY,0) + 1
        sp.edit().putInt(TIMES_USED_KEY,timesUsed).apply()
    }
    fun getThresholdLimit(context: Context):Int{
        var sp = getSharedPref(context)
        return sp.getInt(THRESHOLD_KEY,0)
    }

    fun setThresholdLimit(context: Context,threshold:Int){
        var sp = getSharedPref(context)
        sp.edit().putInt(THRESHOLD_KEY,threshold).apply()
    }

}