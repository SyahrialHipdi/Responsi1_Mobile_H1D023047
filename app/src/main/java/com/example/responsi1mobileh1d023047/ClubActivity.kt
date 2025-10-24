package com.example.responsi1mobileh1d023047

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023047.databinding.ActivityClubBinding

class ClubActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set title bar
        supportActionBar?.title = "Sejarah Klub U.S. Cremonese"

        // Isi data statis
        binding.tvNamaClub.text = "U.S. Cremonese"
        binding.tvSejarah.text = getString(R.string.sejarah).trimIndent()

        // Tombol kembali
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}