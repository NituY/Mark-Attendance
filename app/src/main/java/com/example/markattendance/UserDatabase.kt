package com.example.markattendance

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class UserDatabase(context: Context): SQLiteOpenHelper(context, "USERDB", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE LOGIN(MOBILE_NO INTEGER, PASSWORD INTEGER) ")
        db?.execSQL("INSERT INTO LOGIN(MOBILE_NO, PASSWORD) VALUES('','')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}