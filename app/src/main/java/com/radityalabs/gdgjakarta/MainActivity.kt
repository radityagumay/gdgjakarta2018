package com.radityalabs.gdgjakarta

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.radityalabs.gdgjakarta.extension.snackBar
import com.radityalabs.gdgjakarta.extension.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).setOnClickListener {
            it.snackBar {
                message = "Here is Snackbar"
                duration = Snackbar.LENGTH_SHORT
                action(android.R.string.ok) {
                    toast("OK!")
                }
            }.show()
        }
    }
}

