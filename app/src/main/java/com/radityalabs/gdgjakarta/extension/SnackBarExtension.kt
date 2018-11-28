package com.radityalabs.gdgjakarta.extension

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

fun Activity.toast(message: CharSequence): Unit = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

typealias snackBar = SnackBarBuilder.() -> Unit
typealias UserName = String
typealias Index = Int

fun View.snackBar(process: snackBar): Snackbar {
    val builder = SnackBarBuilder(this)
    builder.process()
    return builder.build()
}

class SnackBarBuilder internal constructor(view: View) {
    private var snackBar = Snackbar.make(view, "", Snackbar.LENGTH_SHORT)

    var message: String? = null
    var duration: Int = Snackbar.LENGTH_SHORT

    fun action(textRes: Int, callback: (View) -> Unit) {
        snackBar.setAction(textRes, callback)
    }

    fun action(text: String, callback: (View) -> Unit) {
        snackBar.setAction(text, callback)
    }

    internal fun build(): Snackbar {
        if (message != null) {
            snackBar.setText(message!!)
        }
        snackBar.duration = duration
        return snackBar
    }
}

fun main(args: Array<String>) {
    val str = buildString {
        append("hello")
        append("\n")
        append("world")
    }

    print(str)
}

fun buildString(actions: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    builder.actions()
    return builder.toString()
}