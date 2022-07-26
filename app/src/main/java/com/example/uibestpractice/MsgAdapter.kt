package com.example.uibestpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(val msgList: List<Msg>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    inner class LeftViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
//    }
//    inner class RightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
//    }

    // 使用密封类更加简单
    sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)
    // 为什么不需要定义为内部类inner class了？
    class LeftViewHolder(view: View) : MsgViewHolder(view) {
        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
    }
    class RightViewHolder(view: View) : MsgViewHolder(view) {
        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
    }

    // 当前项的消息类型（发送、接收）
    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    // 根据消息类型创建相应的ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType ==
        Msg.TYPE_RECEIVED) {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,
            parent, false)
        LeftViewHolder(view)
    } else {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,
            parent, false)
        RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = msgList[position]
//        when (holder) {
//            is LeftViewHolder -> holder.leftMsg.text = msg.content
//            is RightViewHolder -> holder.rightMsg.text = msg.content
//            else -> throw IllegalArgumentException()
//        }
        // 使用密封类，简化代码
        when (holder) {
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }
    override fun getItemCount() = msgList.size
}