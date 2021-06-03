package com.intelligent.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.intelligent.ratingdialog.DialogManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dialogManager = DialogManager(this)
        dialogManager.shouldBeUsedMoreThan(3)
        dialogManager.show()
    }
}