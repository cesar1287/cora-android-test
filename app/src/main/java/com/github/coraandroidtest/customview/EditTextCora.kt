package com.github.coraandroidtest.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.widget.EditText
import com.github.coraandroidtest.R
import com.github.coraandroidtest.core.utils.EditTextCora.FIELD_TYPE_NONE
import com.github.coraandroidtest.core.utils.EditTextCora.STYLE_DEFAULT
import com.github.coraandroidtest.extensions.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class EditTextCora @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr) {

    var fieldType: Int = FIELD_TYPE_NONE

    var maxLength: Int = 0

    var placeholder: String? = null

    init {
        setupStyleables(attrs)
        setupView()
    }

    private fun setupStyleables(attrs: AttributeSet?) {
        getStyledAttributes(attrs).apply {
            try {
                fieldType = getInteger(R.styleable.EditTextCora_fieldType, FIELD_TYPE_NONE)
                maxLength = getInteger(R.styleable.EditTextCora_maxLength, 0)
            } finally {
                recycle()
            }
        }
    }

    private fun getStyledAttributes(attrs: AttributeSet?): TypedArray {
        return context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.EditTextCora,
            0, 0)
    }

    private fun setupView() {
        addView(createEditText().apply {
            setLayoutParams()
            setSingleLine()
        },0)

        setupEditText()
    }

    private fun createEditText(): EditText {
        return TextInputEditText(ContextThemeWrapper(context, STYLE_DEFAULT), null, 0)
    }

    private fun EditText.setLayoutParams() {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT)
    }

    private fun setupEditText() {
        setAllowedDigits()
        setInputType()
        setMaxLength()
        setupMask()
        setPlaceholder()
    }
}