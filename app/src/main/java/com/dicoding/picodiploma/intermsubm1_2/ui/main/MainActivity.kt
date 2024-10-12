package com.dicoding.picodiploma.intermsubm1_2.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.intermsubm1_2.R
import com.dicoding.picodiploma.intermsubm1_2.databinding.ActivityMainBinding
import com.dicoding.picodiploma.intermsubm1_2.response.ListStoryItem
import com.dicoding.picodiploma.intermsubm1_2.ui.addstory.AddStoryActivity
import com.dicoding.picodiploma.intermsubm1_2.ui.auth.LoginActivity
import com.dicoding.picodiploma.intermsubm1_2.ui.map.MapsActivity
import com.dicoding.picodiploma.intermsubm1_2.utils.PreferenceHelper
import com.dicoding.picodiploma.intermsubm1_2.utils.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val _users = MutableLiveData<List<ListStoryItem>>()

    private lateinit var mainViewModel: MainViewModel

    private val preferenceHelper = PreferenceHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //sebenarnya bisa diletakkan didalam viewmodel. karena waktu terbatas, ntaran aja diimplementasikan di projek akhir

        val token = preferenceHelper.getToken()
        if (token == null){
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        val layoutManager = LinearLayoutManager(this)
        binding.rvMain.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvMain.addItemDecoration(itemDecoration)

        mainViewModel = ViewModelProvider(this, ViewModelFactory.getInstance())[MainViewModel::class.java]
        mainViewModel.users.observe(this) { _users ->
            setUserData(_users)
        }

        //Floating Action Button
        binding.fab.setOnClickListener {
            //harus berpindah ke addstoryactivity
            startActivity(Intent(this@MainActivity, AddStoryActivity::class.java))
            finish()
        }

        binding.fabMaps.setOnClickListener {
            //menuju map activity
            startActivity(Intent(this@MainActivity, MapsActivity::class.java))
            finish()
        }



    }

    override fun onBackPressed() {
        finishAffinity()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.logout -> {
                preferenceHelper.clearToken()
                finishAffinity()
            }
        }
        return true
    }

    private fun setUserData(user: List<ListStoryItem>){
        _users.value = user

        val adapter = MainAdapter(user)
        binding.rvMain.adapter = adapter
    }


}