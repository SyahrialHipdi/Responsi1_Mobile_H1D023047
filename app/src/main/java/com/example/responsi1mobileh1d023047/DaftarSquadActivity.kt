//package com.example.responsi1mobileh1d023047
//
////import android.os.Bundle
////import androidx.activity.enableEdgeToEdge
////import androidx.activity.viewModels
////import androidx.appcompat.app.AppCompatActivity
////import androidx.core.view.ViewCompat
////import androidx.core.view.WindowInsetsCompat
////import androidx.recyclerview.widget.LinearLayoutManager
////import com.example.responsi1mobileh1d023047.databinding.ActivityDaftarSquadBinding
////import com.example.responsi1mobileh1d023047.ui.adapter.SquadAdapter
////import kotlin.getValue
////import com.example.responsi1mobileh1d023047.viewmodel.MainViewModel
////import kotlin.io.root
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.responsi1mobileh1d023047.databinding.ActivityDaftarSquadBinding
//import com.example.responsi1mobileh1d023047.data.model.Player
//import com.example.responsi1mobileh1d023047.ui.adapter.SquadAdapter
//import com.example.responsi1mobileh1d023047.ui.adapter.OnPlayerClickListener
//import com.example.responsi1mobileh1d023047.ui.fragment.SquadDetailFragment
//import com.example.responsi1mobileh1d023047.viewmodel.MainViewModel
//
//
//
//class DaftarSquadActivity : AppCompatActivity(){
//    private lateinit var binding: ActivityDaftarSquadBinding
//
//    private val viewModel: MainViewModel by viewModels()
//
////    private val adapter = SquadAdapter(emptyList(), this)
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDaftarSquadBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.adapter = adapter
//
//        viewModel.squadList.observe(this) {
//            adapter.setData(it)
//        }
//
//        viewModel.fetchSquadList(457)
//
//        override fun onPlayerClick(player: Player) {
//            Toast.makeText(this, "Klik: ${player.name}", Toast.LENGTH_SHORT).show()
//        }
//
//    }
//}