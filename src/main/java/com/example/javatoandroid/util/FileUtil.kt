package com.example.javatoandroid.util

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

object FileUtil {
    public fun getStringFromInputStream(input: InputStream):String{
        var resultStr: StringBuilder =java.lang.StringBuilder()
        var inputStreamReader=InputStreamReader(input)
        var breader= BufferedReader(inputStreamReader)
        breader.use {
            breader.forEachLine {
                resultStr.append(it)
            }
        }
        return resultStr.toString()
    }
}