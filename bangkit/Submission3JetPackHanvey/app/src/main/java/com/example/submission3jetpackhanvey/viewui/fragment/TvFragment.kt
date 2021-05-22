package com.example.submission3jetpackhanvey.viewui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission3jetpackhanvey.R
import com.example.submission3jetpackhanvey.databinding.FragTvShowBinding
import com.example.submission3jetpackhanvey.utility.DecorationItem
import com.example.submission3jetpackhanvey.viewui.detail.ActivityDetail
import com.example.submission3jetpackhanvey.viewui.detail.ModelDetailView.Companion.TV_SHOW
import com.example.submission3jetpackhanvey.viewui.MainActivity
import com.example.submission3jetpackhanvey.utility.Helper.BEST_VOTE
import com.example.submission3jetpackhanvey.viewmodel.ViewModelFactory
import com.example.submission3jetpackhanvey.viewui.tv.TvAdapter
import com.example.submission3jetpackhanvey.viewui.tv.TvViewModel
import com.example.submission3jetpackhanvey.vo.StatusConf

class TvFragment : Fragment(),
    TvAdapter.OnItemClickCallback {

    private lateinit var fragmentTvShowBinding: FragTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragTvShowBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            (activity as MainActivity).setActionBarTitle("TV Shows List")

            showProgressBar(true)
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]

            val tvShowAdapter =
                TvAdapter()
            viewModel.getTvShows(BEST_VOTE).observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.statusConf) {
                        StatusConf.LOADING -> showProgressBar(true)
                        StatusConf.SUCCESS -> {
                            showProgressBar(false)
                            tvShowAdapter.submitList(tvShows.data)
                            tvShowAdapter.setOnItemClickCallback(this)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        StatusConf.ERROR -> {
                            showProgressBar(false)
                            Toast.makeText(context, "Error Happened", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            val marginVertical = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16f,
                resources.displayMetrics
            )

            with(fragmentTvShowBinding.rvTvShows) {
                addItemDecoration(DecorationItem(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }

    private fun showProgressBar(state: Boolean) {
        fragmentTvShowBinding.progressTv.isVisible = state
        fragmentTvShowBinding.rvTvShows.isInvisible = state
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        activity?.menuInflater?.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.best_vote -> Toast.makeText(context, "Best Vote", Toast.LENGTH_SHORT).show()
            R.id.worst_vote -> Toast.makeText(context, "Worst Vote", Toast.LENGTH_SHORT).show()
            R.id.random -> Toast.makeText(context, "Random", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClicked(id: String) {
        val intent = Intent(context, ActivityDetail::class.java)
        intent.putExtra(ActivityDetail.EXTRA_FILM, id)
        intent.putExtra(ActivityDetail.EXTRA_CATEGORY, TV_SHOW)

        context?.startActivity(intent)
    }


}