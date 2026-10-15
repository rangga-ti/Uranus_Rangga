package com.example.uranus_rangga.Home.pertemuan_6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uranus_rangga.BaseActivity
import com.example.uranus_rangga.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // Disesuaikan dengan ID XML: etUsername dan etPassword
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Simpan status login ke SharedPreferences
                val sharedPreferences = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                // Navigasi ke BaseActivity setelah login berhasil
                val intent = Intent(this@AuthActivity, BaseActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Harap isi username dan password!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}