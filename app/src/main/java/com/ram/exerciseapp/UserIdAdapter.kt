package com.ram.exerciseapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ram.exerciseapp.databinding.UseridAdapterBinding
import com.ram.exerciseapp.listener.OnCustomListener

class UserIdAdapter constructor(context: Context) :
    RecyclerView.Adapter<UserIdAdapter.UserIdViewHolder>() {

    var mContext: Context? = null
    private var oncustomListener: OnCustomListener? = null

    init {
        mContext = context
        oncustomListener = mContext as OnCustomListener
    }

    private var userId: ArrayList<String>? = null
    fun setData(userId: ArrayList<String>) {
        this.userId = userId
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserIdAdapter.UserIdViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val useridAdapterBinding = UseridAdapterBinding.inflate(layoutInflater, parent, false)
        return UserIdViewHolder(mContext!!, useridAdapterBinding)
    }

    fun OnClicked(data: String): Unit {
        oncustomListener!!.onCustom(data)
    }

    override fun onBindViewHolder(holder: UserIdAdapter.UserIdViewHolder, position: Int) {
        holder.showValue(userId!!.get(position))
    }

    override fun getItemCount(): Int {
        return userId!!.size
    }

    class UserIdViewHolder(context: Context, useridBind: UseridAdapterBinding) :
        RecyclerView.ViewHolder(useridBind.root) {
        var ctx = context
        var userIdBin = useridBind
        fun showValue(usId: String) {
            userIdBin.userId = usId
            userIdBin.adapterIns = UserIdAdapter(ctx)
            userIdBin.executePendingBindings()
        }
    }
}