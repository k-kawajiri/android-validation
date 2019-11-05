package com.k.k.validation.validation

import android.widget.EditText
import androidx.databinding.BindingAdapter

/**
 * バリデーションエラーメッセージを表示する.
 */
@BindingAdapter("errorMessage")
fun setErrorMessage(editText: EditText, data: ValidateLiveData) {
    val errorMessage = when (data.isError) {
        true -> {
            val context = editText.context
            data.messageMap.map { context.getString(it.key, *it.value) }
                .joinToString(separator = "\n")
        }
        else -> null
    }
    editText.error = errorMessage
}
