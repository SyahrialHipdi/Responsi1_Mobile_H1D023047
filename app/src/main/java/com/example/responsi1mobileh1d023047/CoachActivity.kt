package com.example.responsi1mobileh1d023047.ui
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.responsi1mobileh1d023047.databinding.ActivityCoachBinding
import com.example.responsi1mobileh1d023047.viewmodel.MainViewModel

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.coach.observe(this) { coach ->
            binding.tvName.text = coach.name
            binding.tvNationality.text = coach.nationality
            binding.tvDateOfBirth.text = coach.dateOfBirth

            // Gunakan placeholder jika tidak ada foto
            Glide.with(this)
                .load("https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png")
                .into(binding.ivCoach)
        }

        viewModel.fetchCoach(457)
    }
}
