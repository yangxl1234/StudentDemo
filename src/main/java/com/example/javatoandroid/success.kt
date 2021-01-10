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

class success : AppCompatActivity() {
    private val allstudents=ArrayList<ResultOV>()
    //private val data= listOf("apple","daaa","banana","dwwsf")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        val ad=ArrayList<String>()
        ad.add("apple")
        ad.add("banana")
        ad.add("daaa")
        change(ad)
        Log.e("MainActivity",this.applicationContext.toString())
        getInfomation()
        /*for(s in allstudents){
            Log.e("Mad",s.stuName)
        }*/
    }
    public fun change(data:List<String>){
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        listView.adapter = adapter
    }
    public fun sr(s:String){
        Log.e("FAA","s")
}

    public fun getInfomation(){
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
                    var allname = ArrayList<name>()
                    for(app in students){
                        allstudents.add(app)
                        allname.add(name(app.stuName))

                    }
                    for (st in allstudents){
                        Log.e("MainActivity",st.tel)
                    }
//                    val layoutManager=LinearLayoutManager(this)
//                    recyclerView.layoutManager=layoutManager
//                    val adapter= NameAdapter(allname)
//                    recyclerView.adapter=adapter
                    //val data= listOf("apple","daaa","banana","dwwsf")
                    sr("4788------------------------------------")
                    val data= listOf("apple","daaa","banana","dwwsf")
                    change(data)
                }
            }catch (e:Exception){
                e.printStackTrace()
            }finally {

            }
        }
    }
}