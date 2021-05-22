package com.example.submission3jetpackhanvey.viewui.favorite.tvshow

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
import com.example.submission3jetpackhanvey.source.localdata.entitydata.TvShowDataEnt

class TvShowFavAdapter :
    PagedListAdapter<TvShowDataEnt, TvShowFavAdapter.TvShowViewHolder>(
        DIFF_CALLBACK
    ) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowDataEnt>() {
            override fun areItemsTheSame(oldItem: TvShowDataEnt, newItem: TvShowDataEnt): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowDataEnt, newItem: TvShowDataEnt): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun getSwipedData(swipedPosition: Int): TvShowDataEnt? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemMovieBinding =
            ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class TvShowViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowDataEnt) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvDesc.text = tvShow.descript

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(IMAGE_URL + tvShow.img_poster)
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

                itemView.setOnClickListener { onItemClickCallback.onItemClicked(tvShow.id.toString()) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}