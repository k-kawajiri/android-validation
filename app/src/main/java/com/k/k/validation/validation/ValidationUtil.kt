package com.k.k.validation.validation


object ValidationUtil {

    /**
     * バリデーションエラーが一つでもあるか判定する.
     *
     * @param validateLiveData [ValidateLiveData]の配列
     * @return true:バリデーションエラーが一つでもある
     *         false: バリデーションエラーがない
     */
    @JvmStatic
    fun anyError(vararg validateLiveData: ValidateLiveData): Boolean {
        return validateLiveData.any { it.isError }
    }

    /**
     * バリデーションエラーがないことを判定する.
     *
     * @param validateLiveData {@link ValidateLiveData}の配列
     * @return true:バリデーションエラーがない
     *         false: バリデーションエラーが一つでもある
     */
    @JvmStatic
    fun noneError(vararg validateLiveData: ValidateLiveData): Boolean {
        return validateLiveData.none { it.isError }
    }
}