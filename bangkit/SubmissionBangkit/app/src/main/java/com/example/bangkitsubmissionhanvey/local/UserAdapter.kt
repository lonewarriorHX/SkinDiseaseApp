package com.example.bangkitsubmissionhanvey.local

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bangkitsubmissionhanvey.model.User2

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User2){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ??? {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}