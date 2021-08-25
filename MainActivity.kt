package com.hsbc.myapplication5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val myList:MutableList<Dvd> = mutableListOf()
    var mylistView: ListView? = null
    val adapter:MyAdapter? = MyAdapter(this,myList)

    var button:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main_view)
        /**mvc**/
        //Model
        initData()
        //view
        initUI()
        //control
        mylistView!!.adapter = adapter
        initEvent()
    }

    private fun initData() {
        val dvd1 = Dvd("风声鹤唳",1,0,12)
        val dvd2 = Dvd("罗马假日",0,1,15)
        val dvd3 = Dvd("浪漫满屋",1,1,30)
        myList.add(dvd1)
        myList.add(dvd2)
        myList.add(dvd3)

    }


    fun initUI(){
        //listview
        mylistView= findViewById(R.id.mylist)
        button = findViewById(R.id.add)
    }

    fun initEvent(){
        mylistView?.setOnItemClickListener{
                parent,view,position,id ->
            println("position=$position,id=$id")
            val dvd = myList.get(position)

            for((index,value) in myList.withIndex()){
                println("index=$index,value=${value.name}")
            }
            //删除数据
            myList.remove(dvd)
            //刷新页面
            adapter?.notifyDataSetChanged()
            //Toast.makeText(this,dvd.name,Toast.LENGTH_LONG).show()
        }

        button?.setOnClickListener {
            val intent:Intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }
    }
}