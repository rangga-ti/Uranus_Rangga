package com.example.uranus_rangga.Home.pertemuan_6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.uranus_rangga.BaseActivity
import com.example.uranus_rangga.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPreferences = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val isLogin = sharedPreferences.getBoolean("isLogin", false)

            // Arahkan ke BaseActivity jika sudah login, jika belum ke AuthActivity
            val intent = if (isLogin) {
                Intent(this@SplashScreenActivity, BaseActivity::class.java)
            } else {
                Intent(this@SplashScreenActivity, AuthActivity::class.java)
            }

            startActivity(intent)
            finish()
        }, 2000) // Delay 2 detik
    }
}