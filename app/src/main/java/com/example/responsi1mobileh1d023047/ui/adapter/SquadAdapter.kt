package com.example.responsi1mobileh1d023047.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023047.data.model.Player
import com.example.responsi1mobileh1d023047.databinding.ListSquadBinding

class SquadAdapter(
    private var list: List<Player>,
    private val listener: OnPlayerClickListener
) : RecyclerView.Adapter<SquadAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListSquadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            binding.tvName.text = player.name
            binding.tvPosition.text = player.position

            // klik item -> kirim ke listener
            binding.root.setOnClickListener {
                listener.onPlayerClick(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListSquadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    // fungsi untuk memperbarui data dari ViewModel
    fun setData(newList: List<Player>) {
        list = newList
        notifyDataSetChanged()
    }
}

interface OnPlayerClickListener {
    fun onPlayerClick(player: Player)
}
