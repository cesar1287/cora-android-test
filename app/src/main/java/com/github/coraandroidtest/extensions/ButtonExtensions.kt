package com.github.coraandroidtest.extensions

import android.content.Context
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