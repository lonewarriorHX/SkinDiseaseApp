package com.example.submission3jetpackhanvey.viewui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.submission3jetpackhanvey.R
import com.example.submission3jetpackhanvey.databinding.FragFavoriteBinding
import com.example.submission3jetpackhanvey.viewui.MainActivity
import com.example.submission3jetpackhanvey.viewui.ViewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteFragment : Fragment() {

    private var _favoriteFragmentBinding: FragFavoriteBinding? = null
    private val binding get() = _favoriteFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _favoriteFragmentBinding = FragFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            (activity as MainActivity).setActionBarTitle("Favorite")

            setViewPager()
        }
    }

    private fun setViewPager() {
        val fragmentList = listOf(MovieFavoriteFragment(),
            TvShowFavoriteFragment()
        )
        val tabTitle =
            listOf(resources.getString(R.string.movie), resources.getString(R.string.tv_show))

        binding?.viewpager?.adapter =
            ViewpagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
            )

        TabLayoutMediator(binding!!.tabLayout2, binding!!.viewpager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _favoriteFragmentBinding = null
    }
}