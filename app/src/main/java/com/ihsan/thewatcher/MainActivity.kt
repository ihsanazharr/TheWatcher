package com.ihsan.thewatcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.ihsan.thewatcher.adapter.ViewPageAdapter
import com.ihsan.thewatcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPageAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager){ tab, position ->
                when(position){
                    0 -> tab.text = "Movie"
                    1 -> tab.text = "TV"
                    2 -> tab.text = "Profile"
                }
            }.attach()
        }
    }
}