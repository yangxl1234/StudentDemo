package com.example.javatoandroid.model;

public class Student {
    private String stuNo;
    private String stuName;
    private String classes;
    private String gender;
    private String department;
    private String tel;
    private String dormNo;
    private String photoPath;

    public Student(String stuNo, String stuName, String classes, String gender, String department, String tel, String dormNo, String photoPath) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.classes = classes;
        this.gender = gender;
        this.department = department;
        this.tel = tel;
        this.dormNo = dormNo;
        this.photoPath = photoPath;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getStuNo() {
        return stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public String getClasses() {
        return classes;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getTel() {
        return tel;
    }

    public String getDormNo() {
        return dormNo;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", classes='" + classes + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", tel='" + tel + '\'' +
                ", dormNo='" + dormNo + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';

    }
}
