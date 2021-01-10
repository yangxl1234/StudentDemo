package com.example.javatoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javatoandroid.R
import com.example.javatoandroid.model.ResultOV
import com.example.javatoandroid.model.name

class NameAdapter(val students:List<name>) :
    RecyclerView.Adapter<NameAdapter.ViewHolder>(){
    inner class  ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val studentName:TextView=view.findViewById(R.id.studentName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
        val view=LayoutInflater.from(parent.context).inflate(R.layout.stuactivity,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
        val stu=students[position]
        holder.studentName.text=stu.stuname
    }
    override fun getItemCount()=students.size
}