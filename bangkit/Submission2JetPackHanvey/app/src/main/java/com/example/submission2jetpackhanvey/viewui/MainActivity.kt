package com.example.submission2jetpackhanvey.viewui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.submission2jetpackhanvey.R
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_movie, R.id.navigation_tv
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

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