package com.example.bangkitsubmissionhanvey

import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bangkitsubmissionhanvey.data.UserData
import com.example.bangkitsubmissionhanvey.database.DatabaseContract
import com.example.bangkitsubmissionhanvey.databinding.ActivityFavouriteListBinding
import com.example.bangkitsubmissionhanvey.presenter.FavoriteAdapter
import com.example.bangkitsubmissionhanvey.database.FavoriteHelper
import com.example.bangkitsubmissionhanvey.database.MappingHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavouriteList : AppCompatActivity() {
    private lateinit var binding: ActivityFavouriteListBinding
    private lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.favoriteList.layoutManager = LinearLayoutManager(this)
        binding.favoriteList.setHasFixedSize(true)
        adapter = FavoriteAdapter(this)
        adapter.notifyDataSetChanged()
        binding.favoriteList.adapter = adapter

        val hThread = HandlerThread("DataObserver")
        hThread.start()
        val handler = Handler(hThread.looper)

        val dataObserver = object : ContentObserver(handler) {
            override fun onChange(self: Boolean) {
                loadFavoriteDataAsync()
            }
        }

        contentResolver.registerContentObserver(
            DatabaseContract.FavoriteColumns.CONTENT_URI,
            true,
            dataObserver
        )

        if (savedInstanceState == null) {
            loadFavoriteDataAsync()
        } else {
            savedInstanceState.getParcelableArrayList<UserData>(EXTRA_DETAIL).also{
                if (it != null) {
                    adapter.favoriteList = it
                }
            }
        }
    }

    private fun loadFavoriteDataAsync() {
        val favoriteHelper = FavoriteHelper.getInstance(applicationContext)
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
                MappingHelper.mapCursor(cursor)
            }
            val favoriteData = deferredFavorite.await()
            showLoadingCircle(false)
            if (favoriteData.size > 0) {
                adapter.favoriteList = favoriteData
            } else {
                adapter.favoriteList = ArrayList()
                Toast.makeText(this@FavouriteList, R.string.no_favorite, Toast.LENGTH_SHORT)
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