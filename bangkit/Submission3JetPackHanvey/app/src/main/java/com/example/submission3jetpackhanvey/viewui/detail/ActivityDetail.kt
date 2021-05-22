package com.example.submission3jetpackhanvey.viewui.detail

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.submission3jetpackhanvey.BuildConfig.IMAGE_URL
import com.example.submission3jetpackhanvey.R
import com.example.submission3jetpackhanvey.databinding.ActivityDetailBinding
import com.example.submission3jetpackhanvey.source.localdata.entitydata.MovieDataEnt
import com.example.submission3jetpackhanvey.source.localdata.entitydata.TvShowDataEnt
import com.example.submission3jetpackhanvey.viewui.detail.ModelDetailView.Companion.MOVIE
import com.example.submission3jetpackhanvey.viewui.detail.ModelDetailView.Companion.TV_SHOW
import com.example.submission3jetpackhanvey.viewmodel.ViewModelFactory
import com.example.submission3jetpackhanvey.vo.StatusConf
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs


class ActivityDetail : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener,
    View.OnClickListener {

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_CATEGORY = "extra_category"
    }

    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var viewModel: ModelDetailView
    private var dataCategory: String? = null

    private val percentageToShowImage = 20
    private var mMaxScrollSize = 0
    private var mIsImageHidden = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.hide()

        showProgressBar(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[ModelDetailView::class.java]

        detailBinding.fabFavorite.setOnClickListener(this)

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_FILM)
            dataCategory = extras.getString(EXTRA_CATEGORY)

            if (dataId != null && dataCategory != null) {
                viewModel.setFilm(dataId, dataCategory.toString())
                setupState()
                if (dataCategory == MOVIE) {
                    viewModel.getDetailMovie().observe(this, { detail ->
                        when (detail.statusConf) {
                            StatusConf.LOADING -> showProgressBar(true)
                            StatusConf.SUCCESS -> {
                                if (detail.data != null) {
                                    showProgressBar(false)
                                    populateDataDetail(detail.data)
                                }
                            }
                            StatusConf.ERROR -> {
                                showProgressBar(false)
                                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    })
                } else if (dataCategory == TV_SHOW) {
                    viewModel.getDetailTvShow().observe(this, { detail ->
                        when (detail.statusConf) {
                            StatusConf.LOADING -> showProgressBar(true)
                            StatusConf.SUCCESS -> {
                                if (detail.data != null) {
                                    showProgressBar(false)
                                    populateDataDetail(detail.data)
                                }
                            }
                            StatusConf.ERROR -> {
                                showProgressBar(false)
                                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    })
                }
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_favorite -> {
                onFabClicked()
            }
        }
    }

    @JvmName("populateDataDetailForMovie")
    private fun populateDataDetail(movie: MovieDataEnt) {
        with(movie) {

            detailBinding.tvTitleDet.text = this.name
            detailBinding.tvDescDet.text = this.descript
            detailBinding.tvReleaseDate.text = this.dateYear
            detailBinding.tvGenre.text = this.value_score.toString()

            Glide.with(this@ActivityDetail)
                .asBitmap()
                .load(IMAGE_URL + this.img_poster)
                .into(object : CustomTarget<Bitmap>() {
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        detailBinding.ivPoster.setImageBitmap(resource)
                        setPaletteColor(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })

            Glide.with(this@ActivityDetail)
                .load(IMAGE_URL + this.img_preview)
                .into(detailBinding.imgFull)


            showProgressBar(false)
        }
    }

    @JvmName("populateDataDetailForTvShow")
    private fun populateDataDetail(tvShow: TvShowDataEnt) {
        with(tvShow) {

            detailBinding.tvTitleDet.text = this.name
            detailBinding.tvDescDet.text = this.descript
            detailBinding.tvReleaseDate.text = this.dateYear
            detailBinding.tvGenre.text = this.value_score.toString()

            Glide.with(this@ActivityDetail)
                .asBitmap()
                .apply(RequestOptions.placeholderOf(R.drawable.ic_movie_poster_placeholder))
                .load(IMAGE_URL + this.img_poster)
                .into(object : CustomTarget<Bitmap>() {
                    @RequiresApi(Build.VERSION_CODES.M)
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        detailBinding.ivPoster.setImageBitmap(resource)
                        setPaletteColor(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })

            Glide.with(this@ActivityDetail)
                .load(IMAGE_URL + this.img_preview)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_movie_poster_placeholder))
                .into(detailBinding.imgFull)

            showProgressBar(false)
        }
    }

    private fun setupState() {
        if (dataCategory == MOVIE) {
            viewModel.getDetailMovie().observe(this, { movie ->
                when (movie.statusConf) {
                    StatusConf.LOADING -> showProgressBar(true)
                    StatusConf.SUCCESS -> {
                        if (movie.data != null) {
                            showProgressBar(false)
                            val state = movie.data.isFavorite
                            setFavoriteState(state)
                        }
                    }
                    StatusConf.ERROR -> {
                        showProgressBar(false)
                        Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        } else if (dataCategory == TV_SHOW) {
            viewModel.getDetailTvShow().observe(this, { tvShow ->
                when (tvShow.statusConf) {
                    StatusConf.LOADING -> showProgressBar(true)
                    StatusConf.SUCCESS -> {
                        if (tvShow.data != null) {
                            showProgressBar(false)
                            val state = tvShow.data.isFavorite
                            setFavoriteState(state)
                        }
                    }
                    StatusConf.ERROR -> {
                        showProgressBar(false)
                        Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    private fun onFabClicked() {
        if (dataCategory == MOVIE) {
            viewModel.setFavoriteMovie()
        } else if (dataCategory == TV_SHOW) {
            viewModel.setFavoriteTvShow()
        }
    }

    private fun setFavoriteState(state: Boolean) {
        val fab = detailBinding.fabFavorite
        if (state) {
            fab.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            fab.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    private fun showProgressBar(state: Boolean) {
        detailBinding.progressBar.isVisible = state
        detailBinding.fabFavorite.isInvisible = state
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBarLayout?.totalScrollRange ?: 0

        val currentScrollPercentage: Int = (abs(verticalOffset) * 100 / mMaxScrollSize)

        if (currentScrollPercentage >= percentageToShowImage) {
            if (!mIsImageHidden) {
                mIsImageHidden = true
            }
        }

        if (currentScrollPercentage < percentageToShowImage) {
            if (mIsImageHidden) {
                mIsImageHidden = false
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setPaletteColor(poster: Bitmap) {
        Palette.from(poster).generate { palette ->
            val defValue = resources.getColor(R.color.dark, theme)
            detailBinding.viewCard.setCardBackgroundColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            window.statusBarColor = palette?.getDarkMutedColor(defValue) ?: defValue
        }
    }

}