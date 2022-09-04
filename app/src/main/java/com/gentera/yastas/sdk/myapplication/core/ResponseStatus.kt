package com.gentera.yastas.sdk.myapplication.core

import java.lang.Exception

sealed class ResponseStatus<out T> {
    class Loaing<out T> : ResponseStatus<T>()
    data class Success<out T>(val data: T) : ResponseStatus<T>()
    data class Error(val exception: Exception) : ResponseStatus<Nothing>()
}