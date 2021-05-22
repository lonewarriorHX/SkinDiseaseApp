package com.example.bangkitsubmissionhanvey.presenter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bangkitsubmissionhanvey.DetailActivity
import com.example.bangkitsubmissionhanvey.R
import com.example.bangkitsubmissionhanvey.data.UserData
import com.example.bangkitsubmissionhanvey.databinding.RowBinding
import java.util.*

class FavoriteAdapter(private val activity: Activity) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>() {

    var favoriteList = ArrayList<UserData>()
        set(favoriteList) {
            if (favoriteList.size > 0)
                this.favoriteList.clear()
            this.favoriteList.addAll(favoriteList)
            notifyDataSetChanged()
        }

    inner class FavoriteHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        private val binding = RowBinding.bind(view)
        fun bind(user: UserData) {
            with(binding) {
                Glide.with(itemView.context).load(user.avatar).into(avatar)
                detailName.text = user.name
                detailUsername.text = user.username
                itemView.setOnClickListener {
                    val userDetail = UserData(
                        user.id,
                        user.avatar,
                        user.name,
                        user.username,
                        user.repository,
                        user.company,
                        user.location,
                        user.followers,
                        user.following
                    )

                    val mIntent = Intent(activity, DetailActivity::class.java)
                    mIntent.putExtra(DetailActivity.EXTRA_DETAIL, userDetail)
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