package com.example.submissionhanvey.pageadapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionhanvey.R
import com.example.submissionhanvey.databinding.RowBinding
import com.example.submissionhanvey.DataUsers
import com.example.submissionhanvey.pageactivity.UserDetailActivity

class FavoriteAdapter(private val activity: Activity) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>() {

    var favoriteList = ArrayList<DataUsers>()
        set(favoriteList) {
            if (favoriteList.size > 0)
                this.favoriteList.clear()
            this.favoriteList.addAll(favoriteList)
            notifyDataSetChanged()
        }

    inner class FavoriteHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        private val binding = RowBinding.bind(view)
        fun bind(dataUsers: DataUsers) {
            with(binding) {
                Glide.with(itemView.context).load(dataUsers.avatar).into(avatar)
                detailName.text = dataUsers.name
                detailUsername.text = dataUsers.username
                itemView.setOnClickListener {
                    val userDetail = DataUsers(
                        dataUsers.id,
                        dataUsers.avatar,
                        dataUsers.name,
                        dataUsers.username,
                        dataUsers.repository,
                        dataUsers.company,
                        dataUsers.location,
                        dataUsers.followers,
                        dataUsers.following
                    )

                    val mIntent = Intent(activity, UserDetailActivity::class.java)
                    mIntent.putExtra(UserDetailActivity.EXTRA_DETAIL, userDetail)
                    activity.startActivity(mIntent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return FavoriteHolder(inflater)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteHolder, position: Int) {
        holder.bind(favoriteList[position])
    }

    override fun getItemCount(): Int = favoriteList.size

}