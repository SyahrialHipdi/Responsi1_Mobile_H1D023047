package com.example.responsi1mobileh1d023047

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023047.ui.adapter.SquadAdapter
import kotlin.getValue
import com.example.responsi1mobileh1d023047.viewmodel.MainViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023047.data.model.Player
import com.example.responsi1mobileh1d023047.databinding.ActivityDaftarSquadBinding
import com.example.responsi1mobileh1d023047.ui.adapter.OnPlayerClickListener
import com.example.responsi1mobileh1d023047.ui.fragment.SquadDetailFragment


class DaftarSquad : AppCompatActivity(), OnPlayerClickListener {

    private lateinit var binding: ActivityDaftarSquadBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter : SquadAdapter

//    override fun onPlayerClick(player: Player) {
//        Toast.makeText(this, "Klik: ${player.name}", Toast.LENGTH_SHORT).show()
//    }

    override fun onPlayerClick(player: Player){
        player.let { b->
            SquadDetailFragment(
                b.name ?: "No Title",
                b.position ?: "No Title"
            ).show(
                supportFragmentManager,
                SquadDetailFragment::class.java.simpleName
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SquadAdapter(emptyList(), this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.squadList.observe(this) {
            adapter.setData(it)
        }

        // Fetch data dari API (contoh: team ID 457)
        viewModel.fetchSquadList(457)
    }
}

