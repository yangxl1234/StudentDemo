package com.example.javatoandroid

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.ArrayAdapter
import com.example.javatoandroid.model.Student
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_perinfor.*
import kotlinx.android.synthetic.main.listiewlayout.*
import kotlinx.android.synthetic.main.listiewlayout.listView
import kotlinx.android.synthetic.main.personal.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class personalinformation : AppCompatActivity() {
    val downloadImage=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perinfor)
        val stu=intent.getStringExtra("student")
        Log.e("daad",stu.toString())
        val gson=Gson()
        val thisstudent=gson.fromJson(stu, Student::class.java)
        val url="http://8.135.75.74:8080/studentadminsystem/"+thisstudent.photoPath
        //val url="http://8.135.69.192:8080/stuprogram_war/students/boy.jpg"
        textView5.setText(thisstudent.stuName)
        textView6.setText(thisstudent.stuNo)
        textView7.setText(thisstudent.classes)
        textView8.setText(thisstudent.department)
        textView9.setText(thisstudent.dormNo)
        textView10.setText(thisstudent.gender)
        textView11.setText(thisstudent.tel)


        val handler=object:Handler(){
            override fun handleMessage(msg: Message) {
                when(msg.what){
                    downloadImage->{
                        val image=msg.obj as Bitmap
                        imageView.setImageBitmap(image)
                    }
                }
            }
        }
        //button.setOnClickListener {
            thread {
                val urlConnection= URL(url)
                var connection = urlConnection.openConnection() as HttpURLConnection
                connection.connectTimeout=5000

                if(connection.responseCode==HttpURLConnection.HTTP_OK){
                    var inputStream=connection.inputStream
                    val image=BitmapFactory.decodeStream(inputStream)
                    val msg=Message()
                    msg.what=downloadImage
                    msg.obj=image
                    handler.sendMessage(msg)
                }

            //}
        }

    }
}