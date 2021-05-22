package com.example.submission3jetpackhanvey.viewui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.submission3jetpackhanvey.R
import com.example.submission3jetpackhanvey.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setupBottomNav()

        carouselView.pageCount = carouselImages.size
        carouselView.setImageListener{
                position, imageView ->  imageView.setImageResource(carouselImages[position])
        }
        val btn = findViewById<ImageView>(R.id.button1)
        btn.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent);
        }
    }

    private fun setupBottomNav() {
        val bottomNavigationView = binding?.bottomNavMain
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        if (bottomNavigationView != null) {
            NavigationUI.setupWithNavController(
                bottomNavigationView,
                navHostFragment.navController
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainBinding = null
    }

    fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    var carouselImages = intArrayOf(
        R.drawable.bohemian_rhap,
        R.drawable.grey_ana,
        R.drawable.infinity_war,
        R.drawable.gotham_cit,
        R.drawable.fam_guy
    )

    var juduls = arrayOf(
        "bohemian rhapsody",
        "grey anatomy",
        "infinity war",
        "gotham",
        "family guy"
    )

}