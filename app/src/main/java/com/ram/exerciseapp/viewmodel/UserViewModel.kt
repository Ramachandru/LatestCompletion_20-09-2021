package com.ram.exerciseapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ram.exerciseapp.User
import com.ram.exerciseapp.model.api.ApiCall
import com.ram.exerciseapp.model.api.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    private val userData: MutableLiveData<HashMap<String, MutableList<User>>>? =
        MutableLiveData<HashMap<String, MutableList<User>>>()

    fun getUserData(): MutableLiveData<HashMap<String, MutableList<User>>> {
        getRetrofitCall()
        return userData!!
    }

    fun getRetrofitCall() {
        val apiCall = ApiCall.getrofit().create(ApiInterface::class.java)
        val call = apiCall.getGroupOfUser()
        call.enqueue(object : Callback<MutableList<User>> {
            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                userData!!.value = filterUserDatas(response.body()!!)
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                Log.v("ERROR", "ERROR" + t.message)
            }

        })
    }

    fun filterUserDatas(data: MutableList<User>): HashMap<String, MutableList<User>> {
        var maps = HashMap<String, MutableList<User>>()
        for (user in data) {
            filterUserByUserId(maps, user)
        }
        return maps
    }

    fun filterUserByUserId(mapData: HashMap<String, MutableList<User>>, user: User) {
        if (mapData.containsKey(user.userId.toString())) {
            val list = mapData.get(user.userId.toString())
            list!!.add(user)
            mapData.put(user.userId.toString(), list)
        } else {
            val listObj = ArrayList<User>()
            listObj.add(user)
            mapData.put(user.userId.toString(), listObj)
        }
    }
}