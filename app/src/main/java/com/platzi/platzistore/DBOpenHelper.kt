package com.platzi.platzistore

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBOpenHelper (ctx: Context) : ManagedSQLiteOpenHelper(ctx, "PlatziStore", null, 1) {

    companion object{
        private var instance:DBOpenHelper? = null

        fun getInstance(ctx:Context): DBOpenHelper? = if (instance == null) {
            instance = DBOpenHelper(ctx)
            instance
        } else {
            instance
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val id = "id" to INTEGER + PRIMARY_KEY
        val title = "title" to TEXT
        val desc = "desc" to TEXT
        val price = "price" to REAL

        db?.createTable("Productos", true, id, title, desc, price)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable("Productos", true)
    }

    val Context.database:DBOpenHelper?
    get() = getInstance(applicationContext)
}