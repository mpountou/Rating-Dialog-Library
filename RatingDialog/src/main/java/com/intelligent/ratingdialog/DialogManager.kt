package com.intelligent.ratingdialog

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class DialogManager(context: Context) {

    private var context:Context = context
    private var om:OptionManager = OptionManager()

    public fun show(){
        var dialog = Dialog()
        var fm = getFragmentManager(context)


        if (!om.getNeverAskAgain(context)){
            dialog.show(fm!!,"")
        }

    }

    public fun setDialogTitle(title:String){
        om.setTitle(context,title)
    }
    public fun setDialogDescription(title:String){
        om.setDescription(context,title)
    }
    public fun setPositiveButtonTitle(title:String){
        om.setRateTitle(context,title)
    }
    public fun setMaybeLaterButtonTitle(title:String){
        om.setLaterTitle(context,title)
    }
    public fun setNeverAskButtonTitle(title:String){
        om.setNeverTitle(context,title)
    }


    private fun getFragmentManager(context: Context): FragmentManager? {
        val activity = context as AppCompatActivity
        return activity.supportFragmentManager
    }



}