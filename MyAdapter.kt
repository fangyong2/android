package com.hsbc.myapplication5

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context:Context,var mutableList: MutableList<Dvd>): BaseAdapter() {
    override fun getCount(): Int {
        return mutableList.size
    }

    override fun getItem(p0: Int): Any {
       return mutableList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //缓存是行,包含4个textview
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

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //加载行UI组件
        var view:View = View.inflate(context,R.layout.listview_item,null)
        //从行UI组件中提取name
        var name:TextView = view.findViewById(R.id.name)
        var state:TextView = view.findViewById(R.id.state)
        var date:TextView = view.findViewById(R.id.date)
        var count:TextView = view.findViewById(R.id.count)
        var viewHolder:ViewHolder = ViewHolder(name,state,date,count)
        //行视图加载过则从tag直接获取，否则视图存入tag
        if(null==p1){
            //view.tag = name
            view.tag = viewHolder
        }else{
            view  = p1
            //name = view.tag as TextView
            viewHolder = view.tag as ViewHolder
        }
        //指定文本内容
        name.text = mutableList.get(p0).name
        state.text = mutableList.get(p0).state.toString()
        date.text = mutableList.get(p0).date.toString()
        count.text = mutableList.get(p0).count.toString()
        return view!!
    }
}