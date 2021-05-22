package com.example.submission2jetpackhanvey.viewui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission2jetpackhanvey.databinding.ItemRowHeroBinding
import com.example.submission2jetpackhanvey.source.ModelDataEntity
import com.example.submission2jetpackhanvey.utility.Helper.IMG_API_ENDPOINT
import com.example.submission2jetpackhanvey.utility.Helper.IMG_POSTER_SIZE
import com.example.submission2jetpackhanvey.utility.Helper.TYPE_MOVIE
import com.example.submission2jetpackhanvey.utility.Helper.setGlideImage
import com.example.submission2jetpackhanvey.viewui.detail.DetailClassActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {
    private val listMovies = ArrayList<ModelDataEntity>()

    fun setMovie(movies: List<ModelDataEntity>?) {
        if (movies == null) return
        listMovies.clear()
        listMovies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsMovieBinding =
            ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    inner class ListViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: ModelDataEntity) {
            with(binding) {
                tvTitle.text = movie.name
                tvDesc.text = movie.descript

                movie.img_poster?.let {
                    setGlideImage(
                        itemView.context,
                        IMG_API_ENDPOINT + IMG_POSTER_SIZE + it,
                        imgItemPhoto
                    )
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailClassActivity::class.java)
                    intent.putExtra(DetailClassActivity.EXTRA_CONTENT, movie.id)
                    intent.putExtra(DetailClassActivity.EXTRA_TYPE, TYPE_MOVIE)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}