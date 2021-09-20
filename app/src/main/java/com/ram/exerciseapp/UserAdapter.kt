package com.ram.exerciseapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ram.exerciseapp.databinding.UserAdapterBinding

class UserAdapter constructor(context: Context) :
    RecyclerView.Adapter<UserAdapter.UserViewModel>() {
    var mContext: Context? = null
    var listData: MutableList<User>? = null

    init {
        mContext = context
    }

    fun setUserData(listData: MutableList<User>) {
        this.listData = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewModel {
        val layoutInflater = LayoutInflater.from(parent.context)
        val userAdapterBinding = UserAdapterBinding.inflate(layoutInflater, parent, false)
        return UserViewModel(mContext!!, userAdapterBinding)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewModel, position: Int) {
        holder.dispValues(listData!!.get(position))
    }

    fun onClickedData(detail: Integer) {
        Toast.makeText(mContext, "User ID : " + detail, Toast.LENGTH_LONG).show()
    }

    override fun getItemCount(): Int {
        return listData!!.size
    }

    class UserViewModel(context: Context, userBinding: UserAdapterBinding) :
        RecyclerView.ViewHolder(userBinding.root) {
        var userbind = userBinding
        val ctx = context
        fun dispValues(user: User) {
            userbind.userIns = user
            userbind.adapter = UserAdapter(ctx)
            userbind.executePendingBindings()
        }
    }
}