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
        supportActionBar?.title = "Sejarah Klub Manchester City"

        // Isi data statis
        binding.tvNamaClub.text = "Manchester City Football Club"
        binding.tvDidirikan.text = "Didirikan pada tahun 1880 di Manchester, Inggris."
        binding.tvStadion.text = "Stadion Etihad (Etihad Stadium)"
        binding.tvSejarah.text = """
            Manchester City awalnya dikenal sebagai St. Mark’s (West Gorton) pada tahun 1880.
            Klub ini kemudian berganti nama menjadi Ardwick A.F.C. pada tahun 1887, 
            dan akhirnya menjadi Manchester City pada tahun 1894.

            Klub ini mengalami masa keemasan pertama pada akhir 1960-an dan awal 1970-an 
            di bawah manajer Joe Mercer dan asisten Malcolm Allison, memenangkan 
            Liga Inggris, Piala FA, dan Piala Winners Eropa.

            Setelah mengalami masa sulit di divisi bawah, 
            City bangkit kembali pada akhir 2000-an setelah diakuisisi oleh 
            Abu Dhabi United Group pada tahun 2008. 
            Sejak itu, klub menjadi salah satu kekuatan terbesar di Eropa 
            di bawah asuhan Pep Guardiola, memenangkan banyak gelar Premier League 
            dan Liga Champions UEFA pertama mereka pada tahun 2023.
        """.trimIndent()

        // Tombol kembali
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}