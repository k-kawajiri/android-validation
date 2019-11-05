package com.k.k.validation

import androidx.lifecycle.ViewModel
import com.k.k.validation.validation.MaxLength
import com.k.k.validation.validation.MinLength
import com.k.k.validation.validation.Required
import com.k.k.validation.validation.ValidateLiveData

class MainViewModel : ViewModel() {
    /** 必須入力バリデーション */
    var hissu = ValidateLiveData(setOf(Required()))
    /** 最小最大文字長バリデーション */
    var minMax = ValidateLiveData(setOf(MinLength(3L), MaxLength(10L)))
}