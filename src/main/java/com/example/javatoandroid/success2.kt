package com.example.javatoandroid


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javatoandroid.adapter.NameAdapter
import com.example.javatoandroid.model.ResultOV
import com.example.javatoandroid.model.name
import com.example.javatoandroid.util.FileUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.layout.*
import kotlinx.android.synthetic.main.listiewlayout.*
import kotlinx.android.synthetic.main.listiewlayout.listView
import kotlinx.android.synthetic.main.recycleviewlayout.recyclerView
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class success2 : AppCompatActivity() {
    private val allstudents=ArrayList<ResultOV>()
    //private val data= listOf("apple","daaa","banana","dwwsf")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
            thread {
                var conn: HttpURLConnection? = null;
                try {
                var url = URL("http://8.135.75.74:8080/studentadminsystem/returnStudentsServlet")
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


                    //var allname = ArrayList<name>()

                    for(app in students){
                        allstudents.add(app)
                        Log.e("MainActivity","${app.stuName}")
                        //allname.add(name(app.stuName))
                    }
//                    val layoutManager=LinearLayoutManager(this)
//                    recyclerView.layoutManager=layoutManager
//                    val adapter= NameAdapter(allname)
//                    recyclerView.adapter=adapter
                    //val data= listOf("apple","daaa","banana","dwwsf")
                }
            }catch (e:Exception){
                e.printStackTrace()
            }finally {

            }
        }
//        for (st in allstudents){
//            Log.e("MainActivity",st.tel)
//        }
    }
//    public fun change(){
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        listView.adapter = adapter
//    }
}