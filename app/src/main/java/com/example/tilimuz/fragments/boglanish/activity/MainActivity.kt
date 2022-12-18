package com.example.tilimuz.fragments.boglanish.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.tilimuz.R
import com.example.tilimuz.databinding.ActivityMainBinding
import com.example.tilimuz.databinding.NavHeaderMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
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

        /**
         * control fragment
         */
        binding.tvMatn.setOnClickListener{
            navController.navigate(R.id.matnFragment)
            binding.tvMatn.setBackgroundResource(R.drawable.bg_fragment_click)
            binding.tvHujjat.setBackgroundResource(R.drawable.bg_fragment_noclick)
        }
        binding.tvHujjat.setOnClickListener{
            navController.navigate(R.id.hujjatFragment)
            binding.tvHujjat.setBackgroundResource(R.drawable.bg_fragment_click)
            binding.tvMatn.setBackgroundResource(R.drawable.bg_fragment_noclick)
        }
        setupWithNavController(binding.navigationView, navController)
        //binding.drawLayout.open()
        /**
         * if Menu click
         */
        binding.ivMenu.setOnClickListener {
            binding.drawLayout.openDrawer(GravityCompat.START)
        }
        /**
         * if click cancel imageview drawerlayout close
         */
        binding.ivCancel.setOnClickListener {
            binding.drawLayout.closeDrawer(GravityCompat.START)
        }

        binding.loyihaHaqida.setOnClickListener {
            Toast.makeText(this@MainActivity, "uraaaa", Toast.LENGTH_SHORT).show()
        }
/*
//        val headerView = binding.navigationView.getHeaderView(0)
////        val headerBinding = NavHeaderMainBinding.bind(headerView)
//       val headerBinding = ActivityMainBinding.bind(headerView)
//        headerBinding.loyihaHaqida.setOnClickListener {
//            Toast.makeText(this, "Click Loyiha Haqida", Toast.LENGTH_SHORT).show()
//        }
//        headerBinding.tvBoglanish.setOnClickListener {
//            Log.d("TAGTAG", "initViews: Click Boglanish")
//        }
        */
    }

}