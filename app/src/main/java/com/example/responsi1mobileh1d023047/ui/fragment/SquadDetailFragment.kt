package com.example.responsi1mobileh1d023047.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobileh1d023047.R
import com.example.responsi1mobileh1d023047.data.model.Player
import com.example.responsi1mobileh1d023047.databinding.FragmentSquadDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SquadDetailFragment(
    private val name: String,
    private val position: String) : BottomSheetDialogFragment() {

    private var _binding: FragmentSquadDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSquadDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        binding.tvName.text = name
        binding.tvPosition.text = position ?: "Unknown"

        // Jika ada foto atau logo
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
