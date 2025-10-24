package com.example.responsi1mobileh1d023047.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobileh1d023047.data.model.Player
import com.example.responsi1mobileh1d023047.data.model.Coach
import com.example.responsi1mobileh1d023047.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // LiveData yang akan diamati di Activity
    private val _squadList = MutableLiveData<List<Player>>()
    val squadList: LiveData<List<Player>> get() = _squadList

    private val _coach = MutableLiveData<Coach>()
    val coach: LiveData<Coach> get() = _coach

    // Fungsi untuk memanggil API dan mengisi data squad
    fun fetchSquadList(teamId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTeamDetail(teamId)
                if (response.isSuccessful) {
                    val result = response.body()?.squad ?: emptyList()
                    _squadList.value = result
                    Log.d("SUCCESS_GET_SQUAD", "$result")

//                    val team = response.body()
//                    _squadList.value = team?.squad ?: emptyList()
//                    _coach.value = team?.coach
//                    Log.d("SUCCESS_GET_SQUAD", "Squad: ${team?.squad?.size} pemain")
//                    Log.d("SUCCESS_GET_COACH", "Coach: ${team?.coach?.name}")
                } else {
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API_EXCEPTION", e.localizedMessage ?: "Unknown error")
            }
        }
    }

    fun fetchCoach(teamId: Int) {
        viewModelScope.launch {
            try {
                val token = "307f0ad44b264729b46bcfc2bf9a0512"
                val response = RetrofitInstance.api.getTeamDetails(teamId, token)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _coach.postValue(it.coach)
                    }
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("EXCEPTION", e.toString())
            }
        }
    }
}
