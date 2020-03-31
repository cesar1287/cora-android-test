package com.github.coraandroidtest.extensions

import android.text.InputFilter
import android.text.InputType
import android.text.method.DigitsKeyListener
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher
import com.github.coraandroidtest.R
import com.github.coraandroidtest.core.utils.EditTextCora.FIELD_TYPE_ACCOUNT
import com.github.coraandroidtest.core.utils.EditTextCora.FIELD_TYPE_CPF
import com.github.coraandroidtest.core.utils.EditTextCora.FIELD_TYPE_NAME
import com.github.coraandroidtest.core.utils.EditTextCora.FIELD_TYPE_NONE
import com.github.coraandroidtest.core.utils.EditTextCora.FIELD_TYPE_AGENCY
import com.github.coraandroidtest.core.utils.EditTextCora.MAX_LENGTH_CPF
import com.github.coraandroidtest.core.utils.EditTextCora.MAX_LENGTH_DEFAULT
import com.github.coraandroidtest.core.utils.EditTextCora.MAX_LENGTH_NAME
import com.github.coraandroidtest.core.utils.EditTextCora.PLACEHOLDER_ACCOUNT
import com.github.coraandroidtest.core.utils.EditTextCora.PLACEHOLDER_AGENCY
import com.github.coraandroidtest.core.utils.EditTextCora.PLACEHOLDER_CPF
import com.github.coraandroidtest.core.utils.EditTextCora.PLACEHOLDER_NAME
import com.github.coraandroidtest.core.utils.Mask.MASK_CPF
import com.github.coraandroidtest.customview.EditTextCora

const val ALLOWED_DIGITS_NAME = R.string.digits_alpha
const val ALLOWED_DIGITS_CPF = R.string.digits_cpf
const val ALLOWED_DIGITS_NUMBER = R.string.digits_number
const val ALLOWED_DIGITS_OTHER = R.string.digits_alphanumeric

fun EditTextCora.allowedDigits(): String {
    return when (fieldType) {
        FIELD_TYPE_NAME -> context.getString(ALLOWED_DIGITS_NAME)
        FIELD_TYPE_CPF -> context.getString(ALLOWED_DIGITS_CPF)
        FIELD_TYPE_AGENCY, FIELD_TYPE_ACCOUNT -> context.getString(ALLOWED_DIGITS_NUMBER)
        else -> context.getString(ALLOWED_DIGITS_OTHER)
    }
}

fun EditTextCora.setAllowedDigits() {
    val allowedDigits = allowedDigits()
    if (allowedDigits.isNotEmpty()) {
        editText?.keyListener = DigitsKeyListener.getInstance(allowedDigits)
    }
}

fun EditTextCora.inputType(): Int {
    return when (fieldType) {
        FIELD_TYPE_NONE -> {
            InputType.TYPE_CLASS_TEXT
        }
        FIELD_TYPE_CPF, FIELD_TYPE_AGENCY, FIELD_TYPE_ACCOUNT -> {
            InputType.TYPE_CLASS_NUMBER
        }
        FIELD_TYPE_NAME -> {
            InputType.TYPE_TEXT_VARIATION_PERSON_NAME or
                    InputType.TYPE_TEXT_FLAG_CAP_WORDS
        }
        else -> {
            InputType.TYPE_CLASS_TEXT
        }
    }
}

fun EditTextCora.setInputType() {
    editText?.setRawInputType(inputType())
}

fun EditTextCora.maxLength(): Int {
    return when (fieldType) {
        FIELD_TYPE_CPF -> MAX_LENGTH_CPF
        FIELD_TYPE_NAME -> MAX_LENGTH_NAME
        else -> MAX_LENGTH_DEFAULT
    }
}

fun EditTextCora.setMaxLength() {
    editText?.filters = arrayOf(InputFilter.LengthFilter(maxLength()))
}

fun EditTextCora.mask(): String {
    return when (fieldType) {
        FIELD_TYPE_CPF -> MASK_CPF
        else -> ""
    }
}

private fun EditTextCora.setTextWatcher() {
    if (mask().isNotBlank()) {
        editText?.addTextChangedListener(
            MascaraNumericaTextWatcher.Builder()
                .paraMascara(mask())
                .build())
    }
}

fun EditTextCora.setupMask() {
    setTextWatcher()
}

private fun EditTextCora.getPlaceholder(): String? {
    return placeholder ?: when (fieldType) {
        FIELD_TYPE_NAME -> PLACEHOLDER_NAME
        FIELD_TYPE_CPF -> PLACEHOLDER_CPF
        FIELD_TYPE_AGENCY -> PLACEHOLDER_AGENCY
        FIELD_TYPE_ACCOUNT -> PLACEHOLDER_ACCOUNT
        else -> null
    }
}

fun EditTextCora.setPlaceholder(text: String? = getPlaceholder()) {
    post {
        editText?.hint = text
    }
}