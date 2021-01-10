package com.example.javatoandroid

import android.app.PendingIntent.getActivity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.javatoandroid.util.FileUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit.setOnClickListener {
            val data="username=${et_username.text.toString()}&password=${editTextTextPassword.text.toString()}"
            sendRequestWithHttpURLConnection(data,"http://8.135.75.74:8080/studentadminsystem/userLogin")
        }
        loginbtn.setOnClickListener {
            val intent: Intent =(Intent(this,register::class.java))
            startActivity(intent)
        }
    }

    private fun sendRequestWithHttpURLConnection(data:String,urlconnection:String):Unit{
        thread {
            var conn: HttpURLConnection?=null;
            try {
                var url= URL(urlconnection)
                conn=url.openConnection() as HttpURLConnection
                conn.requestMethod="POST"
                conn.connectTimeout=8000
                conn.readTimeout=8000
                var output=conn.outputStream
                output.write(data.toByteArray())
                output.flush()
                var responseCode = conn.responseCode
                if(responseCode==200){
                    //InputStream
                    var input=conn.inputStream
                    var result= FileUtil.getStringFromInputStream(input)
                    //Log.e("MainActivity",result)
                    if(result=="100"){
                        var url2 = URL("http://8.135.75.74:8080/studentadminsystem/returnStudentsServlet")
                        conn = url2.openConnection() as HttpURLConnection
                        conn.requestMethod = "POST"
                        conn.connectTimeout = 8000
                        conn.readTimeout = 8000
                        var responseCode = conn.responseCode
                        if (responseCode.toString() == "200") {
                            //InputStream
                            var input = conn.inputStream;
                            var result = FileUtil.getStringFromInputStream(input)
                            //Log.e("MainActivity2222", result)
                            val intentOK: Intent =(Intent(this,MainActivity2::class.java))
                            intentOK.putExtra("myjson",result)
                            startActivity(intentOK)
                        }
                    }else{
                        Toast.makeText(this,data, Toast.LENGTH_LONG).show()
                    }
                }
            }catch (e:Exception){
                e.printStackTrace()
            }finally {

            }
        }
    }
}
