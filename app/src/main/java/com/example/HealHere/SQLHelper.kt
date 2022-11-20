package com.example.HealHere

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

class SQLHelper(context: Context) :
    SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION ){
        companion object{
            private const val DATABASE_VERSION = 1
            private const val DATABASE_NAME = "healhere.db"
            private const val TABLE_NAME = "tbl_users"
            private const val ID = "id"
            private const val NAME = "name"
            private const val EMAIL = "email"
            private const val PASSWORD = "password"
            private const val CODE = "code"

        }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblUser = ("CREATE TABLE "+ TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + EMAIL + " TEXT, " + PASSWORD + " TEXT, " + CODE + " TEXT" +")" )
        db?.execSQL(createTblUser)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(usr: UserModel): Long{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(ID, usr.id)
        cv.put(NAME, usr.name)
        cv.put(EMAIL, usr.email)
        cv.put(PASSWORD, usr.passwprd)
        cv.put(CODE, usr.code)
        val success = db.insert(TABLE_NAME,null, cv)
        db.close()
        return success

    }



    }
