package com.electrics.watching.data.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> execute(block: suspend () -> Result2<T>): Result2<T> {
    return try {
        withContext(Dispatchers.IO) {
            block()
        }
    } catch (error: Throwable) {
        Result2.Failed(error)
    }
}