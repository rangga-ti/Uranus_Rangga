package com.example.uranus_rangga.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.uranus_rangga.Home.pertemuan_2.SecondActivity
import com.example.uranus_rangga.Home.pertemuan_3.ThirdActivity
import com.example.uranus_rangga.Home.pertemuan_4.FourthActivity
import com.example.uranus_rangga.Home.pertemuan_5.FifthActivity
import com.example.uranus_rangga.Home.pertemuan_6.AuthActivity
import com.example.uranus_rangga.Home.pertemuan_7.SeventhActivity
import com.example.uranus_rangga.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Toolbar di Fragment Home
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        // Navigasi Tombol Pertemuan 2 - 7
        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }
        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }
        binding.btnToFourth.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }
        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }
        binding.btnToSixth.setOnClickListener {
            startActivity(Intent(requireContext(), AuthActivity::class.java))
        }
        binding.btnToSeventh.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    sharedPref.edit().clear().apply()
                    dialog.dismiss()

                    startActivity(Intent(requireContext(), AuthActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}