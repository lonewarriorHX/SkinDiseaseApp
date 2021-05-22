package com.example.bangkitsubmissionhanvey

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.bangkitsubmissionhanvey.model.DataUsers
import com.example.bangkitsubmissionhanvey.presenter.ViewPagerDetail
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setData()
        viewPagerConfig()
    }

    private fun viewPagerConfig() {
        val viewPagerDetailAdapter = ViewPagerDetail(this, supportFragmentManager)
        view_pager.adapter = viewPagerDetailAdapter
        tabs.setupWithViewPager(view_pager)
        supportActionBar?.elevation = 0f
    }


    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {
        //val dataUser = intent.getParcelableExtra(EXTRA_DATA) as DataUsers
        val dataUser = intent?.getParcelableExtra<DataUsers?>(EXTRA_DATA)
        if (dataUser != null) {
            name.text = dataUser.name.toString()
        }
        if (dataUser != null) {
            tv_set_overview.text = "( " + dataUser.username.toString() + " )"
        }
        if (dataUser != null) {
            company.text = dataUser.company.toString()
        }
        if (dataUser != null) {
            location.text = dataUser.location.toString()
        }
        if (dataUser != null) {
            repo.text = dataUser.repository.toString()
        }
        if (dataUser != null) {
            followerss.text = dataUser.followers.toString()
        }
        if (dataUser != null) {
            followings.text = dataUser.following.toString()
        }
        if (dataUser != null) {
            Glide.with(this)
                .load(dataUser.avatar.toString())
                .into(avatars)
        }
    }

}