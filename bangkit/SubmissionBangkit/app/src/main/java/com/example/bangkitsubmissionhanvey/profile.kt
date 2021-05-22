package com.example.bangkitsubmissionhanvey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val logout = findViewById<Button>(R.id.btnLogout)
        logout.setOnClickListener{
            finish();
            System.exit(0);
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}