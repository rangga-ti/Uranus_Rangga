package com.example.uranus_rangga

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uranus_rangga.databinding.ActivityMainBinding
import com.example.uranus_rangga.Home.pertemuan_2.SecondActivity
import com.example.uranus_rangga.Home.pertemuan_3.ThirdActivity
import com.example.uranus_rangga.Home.pertemuan_4.FourthActivity
import com.example.uranus_rangga.Home.pertemuan_5.FifthActivity
import com.example.uranus_rangga.Home.pertemuan_6.AuthActivity
import com.example.uranus_rangga.Home.pertemuan_7.SeventhActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Log Lifecycle onCreate
        Log.e("onCreate", "MainActivity dibuat pertama kali")

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigasi Ke Pertemuan 2
        binding.btnToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Navigasi Ke Pertemuan 3
        binding.btnToThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        // Navigasi Ke Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Rumbai")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        // Navigasi Ke Pertemuan 5
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi Ke Pertemuan 6
        binding.btnToSixth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi Ke Pertemuan 7
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }

        // Fitur Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // Menghapus data SharedPreferences
                    val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    // Kembali ke AuthActivity
                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onstart: MainActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "MainActivity dihapus dari stack")
    }
}