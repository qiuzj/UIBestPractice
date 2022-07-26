package com.example.uibestpractice.sealedclass

// 密封类
sealed class ResultSealed
class Success1(val msg: String) : ResultSealed()
class Failure1(val error: Exception) : ResultSealed()
//class Failure2(val error: Exception) : ResultSealed()

fun getResultMsg1(result: ResultSealed) = when (result) {
    is Success1 -> result.msg
    is Failure1 -> "Error is ${result.error.message}"
//    is Failure2 -> "Error is ${result.error.message}"
}