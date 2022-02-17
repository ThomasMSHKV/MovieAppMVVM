package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presention.home.HomeFragment
import com.example.movieapp.presention.saved.FirstFragment

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setBottomNavigation()
        changeFragment(FirstFragment())

    }

    private fun setBottomNavigation() {

        binding?.bottomNavigationBar?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> changeFragment(HomeFragment())
                R.id.nav_save -> changeFragment(FirstFragment())

            }
            true
        }
    }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}