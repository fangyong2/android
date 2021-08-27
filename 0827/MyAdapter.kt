package com.hsbc.myapplication8

import DVDBean
import android.content.ClipData
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var data: MutableSet<DVDBean>):BaseAdapter() {
    //有多少条数据
    override fun getCount(): Int {
       return  data.size
    }

    //行数据,参数是行ID
    override fun getItem(p0: Int): Any {
        return data.toMutableList()[p0]
    }

    //行ID
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //行缓存UI
    inner class ViewHolder{
        var name:TextView? = null
        var state:TextView? = null

        var date:TextView? = null
        var count:TextView? = null

        constructor(name: TextView?, state: TextView?, date: TextView?, count: TextView?) {
            this.name = name
            this.state = state
            this.date = date
            this.count = count
        }
    }
    //行布局视图
    //p0,行ID
    //p1,行视图 缓存的行视图 如果已经加载过，从缓存取视图，否则从本地取视图。
    //p2,父视图，一般为null
    //tag 从缓存取视图 或者存视图
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //行UI
        var view:View = View.inflate(context,R.layout.listview_item,null)

        var name:TextView = view.findViewById<TextView>(R.id.name)
        var state:TextView = view.findViewById<TextView>(R.id.state)
        var date:TextView = view.findViewById<TextView>(R.id.date)
        var count:TextView = view.findViewById<TextView>(R.id.count)

        var viewHolder:ViewHolder = ViewHolder(name,state,date,count)

        if(null==p1){
            //缓存本地行视图
            //view.tag  = name
            view.tag = viewHolder
        }else{
            view = p1
            //更新
            //name = view.tag as TextView
            viewHolder = view.tag as ViewHolder
        }

        //更新文本
        name.text = data.toMutableList()[p0].name

        state.text = data.toMutableList()[p0].state.toString()
        date.text = data.toMutableList()[p0].date.toString()
        count.text = data.toMutableList()[p0].count.toString()
        return view
    }
}