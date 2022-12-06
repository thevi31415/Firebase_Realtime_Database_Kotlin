package com.example.firebaserealtimedatabase_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firebase: DatabaseReference = FirebaseDatabase.getInstance().getReference()
        btn_insert.setOnClickListener {
            val intent = Intent(this, InsertionActivity::class.java)
           startActivity(intent)
        }
        btn_fetch.setOnClickListener {
           val intent = Intent(this, fetchactivity::class.java)
            startActivity(intent)
        }
    }
}