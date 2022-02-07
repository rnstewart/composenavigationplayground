package com.zmosoft.composenavigationplayground.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment

fun Double.kelvinToFahrenheit(): Double {
    return ((this - 273.15) * (9.toDouble() / 5.toDouble())) + 32.toDouble()
}

fun Activity.hideSoftKeyboard() {
    findViewById<View>(android.R.id.content)?.let { view ->
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Fragment.hideSoftKeyboard() {
    activity?.hideSoftKeyboard()
}

fun Activity.showSoftKeyboard(editText: EditText?) {
    editText?.let {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(it, 0)
    }
}

fun Fragment.showSoftKeyboard(editText: EditText?) {
    activity?.showSoftKeyboard(editText)
}
