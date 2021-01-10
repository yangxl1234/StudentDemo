package com.example.javatoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.javatoandroid.model.ResultOV
import com.example.javatoandroid.model.name
import com.example.javatoandroid.util.FileUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.listiewlayout.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class liststudents : AppCompatActivity() {
    val listView:ListView=findViewById(R.id.listView) as ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        thread {
            var conn: HttpURLConnection? = null;
            try {
                var url = URL("http://8.135.69.192:8080/stuprogram_war/returnStudentsServlet")
                conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "POST"
                conn.connectTimeout = 8000
                conn.readTimeout = 8000
                var responseCode = conn.responseCode
                Log.e("MainActivity", responseCode.toString());
                Log.e("MainActivity", "---------------");
                if (responseCode.toString() == "200") {
                    //InputStream
                    var input = conn.inputStream;
                    var result = FileUtil.getStringFromInputStream(input)
                    Log.e("MainActivity", result)
                    val gson = Gson()
                    val typeOf = object : TypeToken<List<ResultOV>>() {}.type
                    val students = gson.fromJson<List<ResultOV>>(result, typeOf)
                    var allname = ArrayList<name>()
                    val allstudentsname=ArrayList<String>()
                    val allstudents=ArrayList<ResultOV>()
//                    for(app in students){
//                        allstudents.add(app)
//                        allname.add(name(app.stuName))
//                        allstudentsname.add(app.stuName)
//
//                    }
//                    for (st in allstudentsname){
//                        Log.e("MainActivity",st)
//                    }

                }

            }catch (e:Exception){
                e.printStackTrace()
            }finally {
//                val data= listOf("App","da","fee","ffffff")
//                val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//                listView.adapter = adapter
//                Log.e("MainAc","-----------------------")
            }



        }


    }
}