package com.example.javatoandroid.model

data class ResultOV(
    val stuNo: String,
    val stuName: String,
    val classes: String,
    val gender: String,
    val department: String,
    val tel: String,
    val dormNo: String,
    val photoPath: String
){
    /*public override fun toString(): String {
        return "Student{" +
                "stuNo='" + stuNo  +
                ", stuName='" + stuName +
                ", classes='" + classes +
                ", gender='" + gender +
                ", department='" + department +
                ", tel='" + tel +
                ", dormNo='" + dormNo +
                ", photoPath='" + photoPath +
                '}'
    }*/
}