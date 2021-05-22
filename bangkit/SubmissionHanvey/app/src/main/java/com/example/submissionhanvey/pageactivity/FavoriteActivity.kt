package com.example.submissionhanvey.pageactivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionhanvey.R
import com.example.submissionhanvey.pageadapter.FavoriteAdapter
import com.example.submissionhanvey.data.DatabaseContract
import com.example.submissionhanvey.data.FavHelper
import com.example.submissionhanvey.data.MapHelper
import com.example.submissionhanvey.databinding.ActivityFavoriteBinding
import com.example.submissionhanvey.DataUsers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.favoriteList.layoutManager = LinearLayoutManager(this)
        binding.favoriteList.setHasFixedSize(true)
        adapter = FavoriteAdapter(this)
        adapter.notifyDataSetChanged()
        binding.favoriteList.adapter = adapter

        if (savedInstanceState == null) {
            loadFavoriteDataAsync()
        } else {
            savedInstanceState.getParcelableArrayList<DataUsers>(EXTRA_DETAIL).also{
                if (it != null) {
                    adapter.favoriteList = it
                }
            }
        }
    }

    private fun loadFavoriteDataAsync() {
        val favoriteHelper = FavHelper.getInstance(applicationContext)
        GlobalScope.launch(Dispatchers.Main) {
            showLoadingCircle(true)
            favoriteHelper.open()
            val deferredFavorite = async(Dispatchers.IO) {
                val cursor = contentResolver.query(
                    DatabaseContract.FavoriteColumns.CONTENT_URI,
                    null,
                    null,
                    null,
                    null
                )
                MapHelper.mapCursor(cursor)
            }
            val favoriteData = deferredFavorite.await()
            showLoadingCircle(false)
            if (favoriteData.size > 0) {
                adapter.favoriteList = favoriteData
            } else {
                adapter.favoriteList = ArrayList()
                Toast.makeText(this@FavoriteActivity, R.string.no_favorite, Toast.LENGTH_SHORT)
                    .show()
            }
        }
        favoriteHelper.close()
    }

    private fun showLoadingCircle(state: Boolean) {
        if (!state) {
            binding.loadingFavorite.visibility = View.GONE
        } else {
            binding.loadingFavorite.visibility = View.VISIBLE
        }
    }

    companion object {
        var EXTRA_DETAIL = "extra_detail"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_DETAIL, adapter.favoriteList)
    }

    override fun onResume() {
        super.onResume()
        loadFavoriteDataAsync()
    }

}