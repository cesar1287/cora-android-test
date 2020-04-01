package com.github.coraandroidtest.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.core.content.ContextCompat
import com.github.coraandroidtest.R


fun Button.setButtonEnabled(value: Boolean) {
    this.isEnabled = value
}

fun Button.setViewBackgroundEnabled(context: Context) {
    this.background = ContextCompat.getDrawable(context, R.drawable.button_border_enabled)
}

fun Button.setViewBackgroundDisabled(context: Context) {
    this.background = ContextCompat.getDrawable(context, R.drawable.button_border_disabled)
}

fun Context.hideKeyboard(view: View?) {
    val imm: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(view?.windowToken, 0)
}