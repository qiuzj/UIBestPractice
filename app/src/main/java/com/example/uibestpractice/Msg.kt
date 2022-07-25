package com.example.uibestpractice

/**
 * 消息实体类.
 * 定义常量的关键字是const，
 * 注意只有在单例类、companion object或顶层方法中才可以使用const关键字。
 */
class Msg(val content: String, val type: Int) {
    // 消息类型
    companion object {
        const val TYPE_RECEIVED = 0 // 接收
        const val TYPE_SENT = 1 // 发送
    }
}