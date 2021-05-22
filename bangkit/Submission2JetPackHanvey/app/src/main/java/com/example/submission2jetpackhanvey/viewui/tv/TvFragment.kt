package com.example.submission2jetpackhanvey.viewui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission2jetpackhanvey.databinding.TvShowFragBinding
import com.example.submission2jetpackhanvey.viewmodel.ViewModelFactory

class TvFragment : Fragment() {

    private lateinit var viewModel: TvViewModel
    private lateinit var fragmentTvBinding: TvShowFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvBinding = TvShowFragBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            setupRecyclerView()
            val factory = ViewModelFactory.getInstance()
            activity?.let { viewModel = ViewModelProvider(it, factory)[TvViewModel::class.java] }

            fragmentTvBinding.progressBar.visibility = View.VISIBLE
            viewModel.getListTopRatedTvShow().observe(viewLifecycleOwner, { listTvShow ->
                fragmentTvBinding.progressBar.visibility = View.GONE
                fragmentTvBinding.tvShowRv.adapter.let { adapter ->
                    when (adapter) {
                        is TvAdapter -> adapter.setTvShow(listTvShow)
                    }
                }
            })
        }
    }

    private fun setupRecyclerView() {
        fragmentTvBinding.tvShowRv.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = TvAdapter()
        }
    }
}
