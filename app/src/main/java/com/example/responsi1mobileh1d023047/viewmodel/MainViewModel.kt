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

    private val _squadList = MutableLiveData<List<Player>>()
    val squadList: LiveData<List<Player>> get() = _squadList

    private val _coach = MutableLiveData<Coach?>()
    val coach: LiveData<Coach?> get() = _coach

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    // Fungsi untuk mengambil data tim (squad dan coach sekaligus)
    fun fetchTeamData(teamId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getTeamDetail(teamId)
                if (response.isSuccessful) {
                    val teamData = response.body()
                    _squadList.value = teamData?.squad ?: emptyList()
                    _coach.value = teamData?.coach

                    Log.d("SUCCESS_GET_TEAM_DATA", "Squad: ${teamData?.squad?.size} pemain")
                    Log.d("SUCCESS_GET_TEAM_DATA", "Coach: ${teamData?.coach?.name}")
                } else {
                    _errorMessage.value = "Error: ${response.code()} ${response.message()}"
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.value = "Network error: ${e.localizedMessage}"
                Log.e("API_EXCEPTION", e.localizedMessage ?: "Unknown error")
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Fungsi khusus untuk mengambil data coach saja
    fun fetchCoachData(teamId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getTeamDetail(teamId)
                if (response.isSuccessful) {
                    _coach.value = response.body()?.coach
                    Log.d("SUCCESS_GET_COACH", "Coach: ${response.body()?.coach?.name}")
                } else {
                    _errorMessage.value = "Error: ${response.code()} ${response.message()}"
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.value = "Network error: ${e.localizedMessage}"
                Log.e("API_EXCEPTION", e.localizedMessage ?: "Unknown error")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }
}