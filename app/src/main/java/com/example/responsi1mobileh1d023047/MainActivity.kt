package com.example.responsi1mobileh1d023047

import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.net.toUri
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023047.databinding.ActivityMainBinding
import com.example.responsi1mobileh1d023047.databinding.LayoutMenuBinding
import com.example.responsi1mobileh1d023047.data.model.SearchResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.bumptech.glide.Glide
import com.example.responsi1mobileh1d023047.ui.CoachActivity
import retrofit2.*
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {

        binding.layoutBall.let {
            it.imgIcon.setImageResource(R.drawable.ic_ball)
            it.tvLayout.setText(R.string.club)
        }

        binding.layoutPerson.let{
            it.imgIcon.setImageResource(R.drawable.home_24dp)
            it.tvLayout.setText(R.string.coach)
        }
        // Layout Team
        binding.layoutTeam.let {
            it.imgIcon.setImageResource(R.drawable.ic_team)
            it.tvLayout.setText(R.string.squad)
        }
  }

    private fun initListener() {

//        binding.layoutBall.root.setOnClickListener {
//            startActivity(Intent(this, DaftarBukuActivity::class.java))
//        }

        binding.layoutBall.root.setOnClickListener {
            // Contoh aksi: tampilkan toast atau pindah activity
            // startActivity(Intent(this, DetailClubActivity::class.java))
//            startActivity(Intent(this, ClubActivity::class.java))
        }

        binding.layoutPerson.root.setOnClickListener {
            // Misal: tampilkan daftar pemain
            // startActivity(Intent(this, PlayerListActivity::class.java))
            startActivity(Intent(this, CoachActivity::class.java))
        }

        binding.layoutTeam.root.setOnClickListener {
            // Misal: tampilkan detail tim
            // startActivity(Intent(this, TeamActivity::class.java))
            startActivity(Intent(this, DaftarSquad::class.java))
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
