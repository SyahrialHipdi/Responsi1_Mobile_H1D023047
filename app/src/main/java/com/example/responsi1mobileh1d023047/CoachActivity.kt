package com.example.responsi1mobileh1d023047

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.responsi1mobileh1d023047.data.model.Coach
import com.example.responsi1mobileh1d023047.databinding.ActivityCoachBinding
import com.example.responsi1mobileh1d023047.viewmodel.MainViewModel

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan teamId dari intent
        val teamId = intent.getIntExtra("TEAM_ID", 457)

        if (teamId == -1) {
            Toast.makeText(this, "Team ID tidak valid", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        setupObservers()
        viewModel.fetchCoachData(457)

        // Tombol back
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupObservers() {
        viewModel.coach.observe(this, Observer { coach ->
            coach?.let {
                displayCoachData(it)
            } ?: run {
                Toast.makeText(this, "Data pelatih tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayCoachData(coach: Coach) {
        binding.apply {
            tvCoachName.text = coach.name ?: "${coach.firstName ?: ""} ${coach.lastName ?: ""}".trim()
            tvNationality.text = coach.nationality ?: "Tidak diketahui"
            tvDateOfBirth.text = coach.dateOfBirth ?: "Tidak diketahui"

            // Menampilkan informasi kontrak jika ada
            coach.contract?.let { contract ->
                tvContractStart.text = contract.start ?: "Tidak diketahui"
                tvContractUntil.text = contract.until ?: "Tidak diketahui"
            } ?: run {
                tvContractStart.text = "Tidak diketahui"
                tvContractUntil.text = "Tidak diketahui"
            }
        }
    }
}