package com.k.k.validation.validation

import com.k.k.validation.R

sealed class ValidationType() {
    abstract val defaultKey: Int
    abstract val formatArgs: Array<String>

    /**
     * バリデーションを実行する.
     *
     * @param value バリデーション対象の値
     * @return true: 妥当な値である
     */
    abstract fun validate(value: String?): Boolean

    /**
     * バリデーションを実行する（Nullを考慮する）
     *
     * @param value バリデーション対象
     * @param validateIfValueIsNull: バリデーション対象がNullの場合のバリデーション結果
     * @param validateIfValueIsNotNull: バリデーション対象が非Nullの場合のバリデーション処理
     * @return true: 妥当な値である
     */
    protected fun _validate(
        value: String?,
        validateIfValueIsNull: Boolean = true,
        validateIfValueIsNotNull: (String) -> Boolean
    ): Boolean {
        return value?.let {
            validateIfValueIsNotNull.invoke(it)
        } ?: validateIfValueIsNull
    }
}

/**
 * 必須バリデーションクラス.
 */
class Required() : ValidationType() {
    override val defaultKey
        get() = R.string.validation_required

    override val formatArgs: Array<String>
        get() = arrayOf()

    override fun validate(value: String?): Boolean {
        return !value.isNullOrBlank()
    }
}

/**
 * 最低文字数のバリデーションクラス.
 *
 * @param min 最低文字数
 */
class MinLength(private val min: Long) : ValidationType() {
    override val defaultKey
        get() = R.string.validation_min_length

    override val formatArgs: Array<String>
        get() = arrayOf(min.toString())

    override fun validate(value: String?): Boolean {
        return _validate(value) { it -> it.isEmpty() || it.length >= min }
    }
}

/**
 * 最大文字数のバリデーションクラス.
 *
 * @param max 最大文字数
 */
class MaxLength(private val max: Long) : ValidationType() {
    override val defaultKey
        get() = R.string.validation_max_length

    override val formatArgs: Array<String>
        get() = arrayOf(max.toString())

    override fun validate(value: String?): Boolean {
        return _validate(value) { it -> it.length <= max }
    }
}