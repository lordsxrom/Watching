package com.electrics.watching.data.utils

import retrofit2.HttpException
import retrofit2.Response

sealed class Result2<T> {
    data class Success<T>(val data: T) : Result2<T>()
    data class Failed<T>(val throwable: Throwable) : Result2<T>()
}

inline fun <reified T> Response<T>.toResult() =
    if (isSuccessful) {
        Result2.Success(data = body())
    } else {
        Result2.Failed(throwable = HttpException(this))
    }

inline fun <reified T, reified R> Result2<T>.map(mapper: (T) -> R): Result2<R> =
    when (this) {
        is Result2.Success -> {
            try {
                Result2.Success(data = mapper(data))
            } catch (e: Exception) {
                Result2.Failed(e)
            }
        }
        is Result2.Failed -> {
            Result2.Failed(throwable = this.throwable)
        }
    }

inline fun <reified T, reified R> Result2<T>.flatMap(mapper: (T) -> Result2<R>): Result2<R> =
    when (this) {
        is Result2.Success -> {
            try {
                mapper(data)
            } catch (e: Exception) {
                Result2.Failed(e)
            }
        }
        is Result2.Failed -> {
            Result2.Failed(throwable = this.throwable)
        }
    }

fun <T> Result2<T>.getOrNull(): T? = if (this is Result2.Success) this.data else null

fun <T> Result2<T>.ifSuccess(block: (data: T) -> Unit): Result2<T> {
    if (this is Result2.Success) block(data)
    return this
}

fun <T> Result2<T>.ifFailure(block: (throwable: Throwable) -> Unit): Result2<T> {
    if (this is Result2.Failed) block(throwable)
    return this
}

inline fun <reified T> runResulting(block: () -> T): Result2<T> =
    try {
        Result2.Success(data = block())
    } catch (e: Exception) {
        Result2.Failed(e)
    }

inline fun <reified T> runQuery(block: () -> Response<T>): Result2<T?> =
    try {
        Result2.Success(data = block().body())
    } catch (e: Exception) {
        Result2.Failed(e)
    }
