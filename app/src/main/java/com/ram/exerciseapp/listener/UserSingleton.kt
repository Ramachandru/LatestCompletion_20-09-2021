package com.ram.exerciseapp.listener

import com.ram.exerciseapp.User

object UserSingleton
{
    private var hashList : HashMap<String,MutableList<User>>?=null
    fun setAllList(hashList : HashMap<String,MutableList<User>>){
        UserSingleton.hashList = hashList
    }
    fun getAllList() = hashList
}