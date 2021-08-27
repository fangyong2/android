package com.hsbc.myapplication8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var name:EditText? = null
    var submit:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //实例化视图组件
        initUI()
        //初始化按钮事件
        initEvent()
    }

    private fun initEvent() {
        //点击事件
        submit?.setOnClickListener {
            //获取输入框的值
            var value = name?.text
            println(value)
            Toast.makeText(this,value,Toast.LENGTH_LONG).show()

            //和服务端交互开始。。。。。。。。。。。。
            doAdd_ResultFul(value.toString())
            //和服务端交互结束。。。。。。。。。。。。

            //跳转到view页面，查看刚才添加的数据
            //Intent 网页的跳转，传参数
            val intent:Intent = Intent(this,ViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun doAdd_ResultFul(value: String?) {
        //1.配置远程主机信息
        val client = OkHttpClient()
        val baseUrl = "http://121.37.170.216:8080"
        val url = "$baseUrl/dvd"

        //2.移动端请求服务端的（json数据=map）
        val json = JSONObject()
        json.put("name",value)
        //body
        val requestBody:RequestBody = json.toString().toRequestBody()

        //3.构建页面请求
        var builder = Request.Builder()
        builder.url(url)
        builder.addHeader("Content-Type","application/json")
            .put(requestBody)

        //4.服务端响应移动端
        client.newCall(builder.build()).enqueue(object:Callback{
            //失败
            override fun onFailure(call: Call, e: IOException) {
                println("失败\t$e")
            }
            //成功
            override fun onResponse(call: Call, response: Response) {
                val s = response.body?.string()
                println("成功\t$s")

                runOnUiThread {
                    Toast.makeText(this@MainActivity,s,Toast.LENGTH_LONG).show()
                }
            }

        })
    }

    //| http://121.37.170.216:8080/dvd?name=测试 		|PUT 	|
    //AndroidManifest.xml
    //
    //    <uses-permission android:name="android.permission.INTERNET"></uses-permission>
    //    android:usesCleartextTraffic="true"


    private fun initUI() {
       name= this.findViewById<EditText>(R.id.name)
       submit = this.findViewById<Button>(R.id.submit)
    }


}