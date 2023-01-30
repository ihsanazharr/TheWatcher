package com.ihsan.thewatcher.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ihsan.thewatcher.fragment.MovieFragment
import com.ihsan.thewatcher.fragment.ProfileFragment
import com.ihsan.thewatcher.fragment.TelevisionFragment

class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = MovieFragment()
            1 -> fragment = TelevisionFragment()
            2 -> fragment = ProfileFragment()
        }
        return fragment
    }

}