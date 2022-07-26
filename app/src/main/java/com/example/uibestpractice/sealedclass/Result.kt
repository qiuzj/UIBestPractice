package com.example.uibestpractice.sealedclass

interface Result
class Success(val msg: String) : Result
class Failure(val error: Exception) : Result

fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
    // 根据Kotlin的语法，else必须出现
    else -> throw IllegalArgumentException()
}