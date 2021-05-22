package com.example.submissionhanvey.pageadapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionhanvey.databinding.RowBinding
import com.example.submissionhanvey.DataUsers
import com.example.submissionhanvey.pageactivity.UserDetailActivity
import java.util.*
import kotlin.collections.ArrayList

class UserAdapter(private var githubDataUsers: ArrayList<DataUsers>) :
    RecyclerView.Adapter<UserAdapter.UserHolder>(),
    Filterable {

    var userList = ArrayList<DataUsers>()
    private lateinit var mContext: Context

    inner class UserHolder(private val binding: RowBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        mContext = parent.context
        return UserHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(githubDataUsers[position])
    }

    override fun getItemCount(): Int = githubDataUsers.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val search = p0.toString()
                userList = if (search.isEmpty()) {
                    githubDataUsers
                } else {
                    val searchResult = ArrayList<DataUsers>()
                    for (row in userList) {
                        if ((row.username.toString().toLowerCase(Locale.ROOT)
                                .contains(search.toLowerCase(Locale.ROOT)))
                        ) {
                            searchResult.add(
                                DataUsers(
                                    row.id,
                                    row.avatar,
                                    row.name,
                                    row.username,
                                    row.repository,
                                    row.company,
                                    row.location,
                                    row.followers,
                                    row.following
                                )
                            )
                        }
                    }
                    searchResult
                }
                val filterResult = FilterResults()
                filterResult.values = userList
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                userList = p1?.values as ArrayList<DataUsers>
                notifyDataSetChanged()
            }
        }
    }

    private var selectUser: SelectUser? = null

    fun setSelectUser(selectUser: SelectUser) {
        this.selectUser = selectUser
    }

    interface SelectUser {
        fun onSelectedUser(data: DataUsers)
    }
}
