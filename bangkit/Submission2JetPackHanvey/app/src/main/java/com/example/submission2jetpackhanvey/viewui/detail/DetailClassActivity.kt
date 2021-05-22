package com.example.submission2jetpackhanvey.viewui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.submission2jetpackhanvey.databinding.ActivityDetailBinding
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.submission2jetpackhanvey.utility.Helper.IMG_API_ENDPOINT
import com.example.submission2jetpackhanvey.utility.Helper.IMG_BACKGROUND_SIZE
import com.example.submission2jetpackhanvey.utility.Helper.IMG_POSTER_SIZE
import com.example.submission2jetpackhanvey.utility.Helper.TYPE_MOVIE
import com.example.submission2jetpackhanvey.utility.Helper.TYPE_TVSHOW
import com.example.submission2jetpackhanvey.utility.Helper.setGlideImage
import com.example.submission2jetpackhanvey.viewmodel.ViewModelFactory

class DetailClassActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CONTENT = "extra_content"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[ViewModelDetail::class.java]

        activityDetailBinding.progressBar.visibility = View.VISIBLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getIntExtra(EXTRA_CONTENT, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if(type.equals(TYPE_MOVIE)) {
            viewModel.getMovieDetail(id).observe(this, {
                displayData(it)
            })
        } else if (type.equals(TYPE_TVSHOW)) {
            viewModel.getTvShowDetail(id).observe(this, {
                it?.let {
                    displayData(it)
                }
            })
        }
    }

    private fun displayData(data: ModelDataEntity) {
        activityDetailBinding.progressBar.visibility = View.GONE
        activityDetailBinding.tvTitleDet.text = data.name
        activityDetailBinding.tvDescDet.text = data.descript
        activityDetailBinding.tvReleaseDate.text = data.dateRelease
        activityDetailBinding.tvGenre.text = data.value_score
        supportActionBar?.title = data.name
        setGlideImage(
            this@DetailClassActivity,
            IMG_API_ENDPOINT + IMG_POSTER_SIZE + data.img_poster,
            activityDetailBinding.imgFull
        )

        setGlideImage(
            this@DetailClassActivity,
            IMG_API_ENDPOINT + IMG_BACKGROUND_SIZE + data.preview_image,
            activityDetailBinding.imgItemPhoto
        )


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}