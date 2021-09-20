package com.ram.exerciseapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ram.exerciseapp.listener.UserSingleton

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)
        val data = intent.getStringExtra("userId")
        val list = UserSingleton.getAllList()!!.get(data)
        val recycle = findViewById<RecyclerView>(R.id.userRecycle)
        val userAdapter = UserAdapter(this@UserActivity)
        userAdapter.setUserData(list!!)
        val linearLayoutManager = LinearLayoutManager(this@UserActivity)
        recycle.adapter = userAdapter
        recycle.layoutManager = linearLayoutManager
    }
}