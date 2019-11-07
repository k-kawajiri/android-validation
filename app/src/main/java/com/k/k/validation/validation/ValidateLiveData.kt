package com.k.k.validation.validation

import androidx.lifecycle.MutableLiveData

class ValidateLiveData(val validationTypeList: Set<ValidationType>) :
    MutableLiveData<String>() {
    private var _isError = false
    val isError: Boolean
        get() = _isError
    var messageMap = mutableMapOf<Int, Array<String>>()

    override fun setValue(value: String) {
        super.setValue(value)
        _isError = validate(value)
    }

    override fun postValue(value: String) {
        super.postValue(value)
        _isError = validate(value)
    }

    override fun onActive() {
        super.onActive()
        _isError = validate(value)
    }

    /**
     * バリデーションを実行する.
     *
     * @param value バリデーション対象の値.
     * @return true:バリデーション結果がOKである.
     */
    private fun validate(value: String?): Boolean {
        // second:バリデーションNGである.
        val validationResultPartition = validationTypeList.partition { it.validate(value) }
        messageMap = validationResultPartition.second.associateBy(
            { it -> it.defaultKey },
            { it -> it.formatArgs }
        ).toMutableMap()

        return validationResultPartition.second.isNotEmpty()
    }

}