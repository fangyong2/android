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

class AddActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main_add)
        initUI()
    }

    fun initUI(){
        //编辑框
        val name:EditText = findViewById<EditText>(R.id.name)
        //按钮
        val submit: Button = findViewById<Button>(R.id.submit)

        //输出编辑文本的值
        println(name.text)
        Toast.makeText(this,name.text,Toast.LENGTH_LONG).show()

        //按钮绑定onclick事件
        submit.setOnClickListener {
            //Toast.makeText(this,name.text,Toast.LENGTH_LONG).show()
            //1.远程主机
            val client = OkHttpClient()
            val baseUrl = "http://121.37.170.216:8080"
            val url = "$baseUrl/dvd"

            //2.json数据
            val json = JSONObject()
            json.put("name",name.text)
            val requestBody:RequestBody = json.toString().toRequestBody()

            //3.构建页面request请求
            var builder = Request.Builder()
            builder.url(url)
            builder.addHeader("Content-type","application/json")
                .put(requestBody)

            //4.页面响应
            client.newCall(builder.build()).enqueue(object:Callback{
                override fun onFailure(call: Call, e: IOException) {
                    println("失败$e")
                }

                override fun onResponse(call: Call, response: Response) {
                    val res = response.body?.string()
                    println("成功 $res")

                    runOnUiThread(){
                        Toast.makeText(this@AddActivity,res,Toast.LENGTH_LONG).show()
                    }
                }

            })
        }
    }
}