package com.dicoding.picodiploma.intermsubm1_2.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.intermsubm1_2.repository.AuthRepository
import com.dicoding.picodiploma.intermsubm1_2.response.ListStoryItem
import com.dicoding.picodiploma.intermsubm1_2.response.StoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(val authRepository: AuthRepository): ViewModel() {

    private val _users = MutableLiveData<List<ListStoryItem>>()
    val users: LiveData<List<ListStoryItem>> = _users


    init {
        getStories()
    }

    private fun getStories(){
        val client = authRepository.postStories()
        client.enqueue(object : Callback<StoriesResponse>{
            override fun onResponse(
                call: Call<StoriesResponse>,
                response: Response<StoriesResponse>
            ) {
                if (response.isSuccessful){
                    _users.value = response.body()?.listStory
                }else{
                    Log.d("Failure", response.message().toString())
                }
            }

            override fun onFailure(call: Call<StoriesResponse>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }

        })
    }

}