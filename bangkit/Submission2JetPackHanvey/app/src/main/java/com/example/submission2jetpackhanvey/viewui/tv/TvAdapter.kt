package com.example.submission2jetpackhanvey.viewui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission2jetpackhanvey.databinding.ItemRowHeroBinding
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.submission2jetpackhanvey.utility.Helper.IMG_API_ENDPOINT
import com.example.submission2jetpackhanvey.utility.Helper.IMG_POSTER_SIZE
import com.example.submission2jetpackhanvey.utility.Helper.TYPE_TVSHOW
import com.example.submission2jetpackhanvey.utility.Helper.setGlideImage
import com.example.submission2jetpackhanvey.viewui.detail.DetailClassActivity

class TvAdapter :
    RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    private val listTvShow = ArrayList<ModelDataEntity>()

    fun setTvShow(tvShows: List<ModelDataEntity>) {
        listTvShow.clear()
        listTvShow.addAll(tvShows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemsMovieBinding =
            ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    inner class TvViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: ModelDataEntity) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvDesc.text = tvShow.descript

                tvShow.img_poster?.let {
                    setGlideImage(
                        itemView.context,
                        IMG_API_ENDPOINT + IMG_POSTER_SIZE + it,
                        imgItemPhoto
                    )
                }
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailClassActivity::class.java)
                    intent.putExtra(DetailClassActivity.EXTRA_CONTENT, tvShow.id)
                    intent.putExtra(DetailClassActivity.EXTRA_TYPE, TYPE_TVSHOW)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}