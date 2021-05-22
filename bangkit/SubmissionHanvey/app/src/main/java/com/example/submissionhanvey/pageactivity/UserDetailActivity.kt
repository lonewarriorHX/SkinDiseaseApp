package com.example.submissionhanvey.pageactivity

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.submissionhanvey.R
import com.example.submissionhanvey.pageadapter.ViewPagerAdapter
import com.example.submissionhanvey.data.DatabaseContract
import com.example.submissionhanvey.data.FavHelper
import com.example.submissionhanvey.data.MapHelper
import com.example.submissionhanvey.databinding.ActivityDetailBinding
import com.example.submissionhanvey.DataUsers
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inflater: ActivityDetailBinding
    private lateinit var favHelper: FavHelper

    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflater = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(inflater.root)

        favHelper = FavHelper.getInstance(applicationContext)
        favHelper.open()

        val userDetails = intent.getParcelableExtra<DataUsers>(EXTRA_DETAIL) as DataUsers
        inputData(userDetails)
        setFavoriteState(userDetails)

        inflater.btnFavorite.setOnClickListener(this)

        favHelper.close()

        val pagerAdapter = ViewPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = pagerAdapter

        val detailTabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(detailTabs, viewPager) { detailTabs, position ->
            detailTabs.text = resources.getString(TABS[position])
        }.attach()
    }

    private fun inputData(dataUsersDetails: DataUsers) {
        inflater.name.text = dataUsersDetails.name
        inflater.tvSetOverview.text = dataUsersDetails.username
        inflater.repo.text = getString(R.string.repository, dataUsersDetails.repository)
        inflater.followerss.text = getString(R.string.company, dataUsersDetails.company)
        inflater.followings.text = getString(R.string.location, dataUsersDetails.location)
        Glide.with(this).load(dataUsersDetails.avatar).into(inflater.avatar)
    }

    override fun onClick(p0: View?) {
        val userDetails = intent.getParcelableExtra<DataUsers>(EXTRA_DETAIL) as DataUsers
        if (p0?.id == R.id.btn_favorite) {
            val values = ContentValues()
            if (isFavorite) {
                isFavorite = false
                favHelper.deleteById(userDetails.id)
                Toast.makeText(this, R.string.unfavorited, Toast.LENGTH_SHORT).show()
            } else {
                isFavorite = true
                values.put(DatabaseContract.FavoriteColumns.ID, userDetails.id)
                values.put(DatabaseContract.FavoriteColumns.AVATAR, userDetails.avatar)
                values.put(DatabaseContract.FavoriteColumns.NAME, userDetails.name)
                values.put(DatabaseContract.FavoriteColumns.USERNAME, userDetails.username)
                values.put(DatabaseContract.FavoriteColumns.REPOSITORY, userDetails.repository)
                values.put(DatabaseContract.FavoriteColumns.COMPANY, userDetails.company)
                values.put(DatabaseContract.FavoriteColumns.LOCATION, userDetails.location)
                favHelper.insertData(values)
                Toast.makeText(this, R.string.favorited, Toast.LENGTH_SHORT).show()
            }
        }
        setFavoriteState(userDetails)
    }

    private fun setFavoriteState(dataUsers: DataUsers) {
        GlobalScope.launch(Dispatchers.Main) {
            favHelper.open()

            val deferredFavoriteUser = async(Dispatchers.IO) {
                val cursor = favHelper.queryByUsername(dataUsers.username)
                MapHelper.mapCursor(cursor)
            }

            val favoriteUser = deferredFavoriteUser.await()

            favoriteUser.forEach {
                if (it.username == dataUsers.username)
                    isFavorite = true
            }
            checkFavoriteState()
        }
        favHelper.close()
    }

    private fun checkFavoriteState() {
        if (isFavorite)
            inflater.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite)
        else
            inflater.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border)
    }

    companion object {
        var EXTRA_DETAIL = "extra_detail"

        @StringRes
        private val TABS = intArrayOf(
            R.string.followers,
            R.string.following
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}