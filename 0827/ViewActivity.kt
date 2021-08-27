package com.hsbc.myapplication8

import DVDBean
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.ListView

class ViewActivity : AppCompatActivity() {

    /**MVC模式*/
    //1.model
    /*创建数组存储DVD信息*/
    private var dvdList = mutableSetOf<DVDBean>()

    //2.View  (listview item) =  (table tr td td td td)
    var listView:ListView? = null

    //3.control 适配器
    var adapter:BaseAdapter? = MyAdapter(this,dvdList)

    init {
        val dvdBean1 = DVDBean("罗马假日", 0, 1, 15)
        val dvdBean2 = DVDBean("风声鹤唳", 1, 0, 12)
        val dvdBean3 = DVDBean("浪漫满屋", 1, 0, 30)
        dvdList.add(dvdBean1)
        dvdList.add(dvdBean2)
        dvdList.add(dvdBean3)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        //实例化视图组件
        initUI()
        //初始化按钮事件
        initEvent()
    }

    private fun initEvent() {
        //点击事件

    }

    private fun initUI() {
        listView = findViewById(R.id.list)
        listView?.adapter = adapter
    }


}