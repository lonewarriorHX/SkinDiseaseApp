package com.example.submission3jetpackhanvey.viewui.movie

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.paging.PagedListAdapter
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.submission3jetpackhanvey.BuildConfig.IMAGE_URL
import com.example.submission3jetpackhanvey.R
import com.example.submission3jetpackhanvey.databinding.ItemRowHeroBinding
import com.example.submission3jetpackhanvey.source.localdata.entitydata.MovieDataEnt

class MovieAdapter : PagedListAdapter<MovieDataEnt, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieDataEnt>() {
            override fun areItemsTheSame(oldItem: MovieDataEnt, newItem: MovieDataEnt): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieDataEnt, newItem: MovieDataEnt): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding =
            ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class MovieViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieDataEnt) {
            with(binding) {
                tvTitle.text = movie.name
                tvDesc.text = movie.descript

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(IMAGE_URL + movie.img_poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_movie_poster_placeholder))
                    .transform(RoundedCorners(28))
                    .into(object : CustomTarget<Bitmap>() {
                        @RequiresApi(Build.VERSION_CODES.M)
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            ivPoster.setImageBitmap(resource)

                            Palette.from(resource).generate { palette ->
                                val defValue = itemView.resources.getColor(
                                    R.color.dark,
                                    itemView.context.theme
                                )
                                cardItem.setCardBackgroundColor(
                                    palette?.getDarkMutedColor(defValue)
                                        ?: defValue
                                )
                            }
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })

                itemView.setOnClickListener { onItemClickCallback.onItemClicked(movie.id.toString()) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}