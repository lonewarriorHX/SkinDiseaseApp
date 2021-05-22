package com.example.submissionhanvey.pageadapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.submissionhanvey.fragment.FollowerFragment
import com.example.submissionhanvey.fragment.FollowingFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private val items = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0) {
            fragment = FollowerFragment()
        } else if (position == 1) {
            fragment = FollowingFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int = items
}