package com.ram.exerciseapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ram.exerciseapp.listener.OnCustomListener
import com.ram.exerciseapp.listener.UserSingleton
import com.ram.exerciseapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity(), OnCustomListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycle = findViewById<RecyclerView>(R.id.recycle)
        val userIdAdapter = UserIdAdapter(this@MainActivity)
        val userViewModel = ViewModelProvider(this@MainActivity).get(UserViewModel::class.java)
        userViewModel.getUserData().observe(this, Observer { data ->
            UserSingleton.setAllList(data)
            val list = ArrayList<String>()
            list.addAll(data.keys)
            userIdAdapter.setData(list)
            userIdAdapter.notifyDataSetChanged()
        })
        userIdAdapter.setData(ArrayList())
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recycle.adapter = userIdAdapter
        recycle.layoutManager = linearLayoutManager
    }

    override fun onCustom(userId: String) {
        val lIntent = Intent(this@MainActivity, UserActivity::class.java)
        lIntent.putExtra("userId", userId)
        startActivity(lIntent)
    }
}