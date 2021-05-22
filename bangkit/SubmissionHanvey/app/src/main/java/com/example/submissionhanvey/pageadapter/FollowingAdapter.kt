package com.example.submissionhanvey.pageadapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionhanvey.databinding.RowBinding
import com.example.submissionhanvey.DataUsers
import com.example.submissionhanvey.pageactivity.UserDetailActivity

class FollowingAdapter(private val followingList: ArrayList<DataUsers>) :
    RecyclerView.Adapter<FollowingAdapter.FollowingHolder>() {
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingHolder {
        val binding =
            RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        mContext = parent.context

        return FollowingHolder(binding)
    }

    override fun getItemCount(): Int = followingList.size

    inner class FollowingHolder(private val binding: RowBinding) :
        RecyclerView.ViewHolder(binding.root) {
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

                    val mIntent = Intent(mContext, UserDetailActivity::class.java)
                    mIntent.putExtra(UserDetailActivity.EXTRA_DETAIL, userDetail)
                    mContext.startActivity(mIntent)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: FollowingHolder, position: Int) {
        holder.bind(followingList[position])
    }
}
