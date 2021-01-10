package com.example.javatoandroid

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_failure.*
import kotlinx.android.synthetic.main.activity_perinfor.*
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import kotlin.concurrent.thread

class register : AppCompatActivity() {
    val success1=1
    val failure1=2
    val handler=object: Handler(){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                success1 ->{
                    text_register.text="注册成功"
                }
                failure1 ->{
                    text_register.text="注册失败"
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failure)




        submitregister.setOnClickListener {
            var username1=username.text
            var psw1=password1.text
            var psw2=password2.text
            //Toast.makeText(this,"${username1}  ${psw1}  ${psw2}",Toast.LENGTH_LONG).show()
            if(psw1.toString()!=psw2.toString()){
                Toast.makeText(this,"密码不一致",Toast.LENGTH_LONG).show()
            }else{
                thread {
                    try {
                        val client=OkHttpClient()
                        val requestBody=FormBody.Builder()
                            .add("username", username1.toString())
                            .add("password", psw1.toString())
                            .build()
                        val request=Request.Builder()
                            .url("http://8.135.75.74:8080/studentadminsystem/registerServlet")
                            .post(requestBody)
                            .build()
                        val response=client.newCall(request).execute()
                        val responseData=response.body?.string()
                        val msg= Message()
                        if(responseData=="100"){
                            msg.what=success1
                        }else{
                            msg.what=failure1
                        }
                        handler.sendMessage(msg)
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }
        }

    }
}