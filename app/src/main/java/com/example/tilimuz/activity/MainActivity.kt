package com.example.tilimuz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.tilimuz.R
import com.example.tilimuz.databinding.ActivityMainBinding
import com.example.tilimuz.databinding.NavHeaderMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        binding.ivMenu.setOnClickListener {
            binding.drawLayout.openDrawer(GravityCompat.START)
        }
        val headerView = binding.navigationView.getHeaderView(0)
        val headerBinding = NavHeaderMainBinding.bind(headerView)
        headerBinding.loyihaHaqida.setOnClickListener {
            Toast.makeText(this, "Click Loyiha Haqida", Toast.LENGTH_SHORT).show()
        }
        headerBinding.tvBoglanish.setOnClickListener {
            Log.d("TAGTAG", "initViews: Click Boglanish")
        }
    }

}