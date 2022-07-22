package com.example.shoeshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoeshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val controller = this.findNavController(R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this, controller)

    }
    override fun onSupportNavigateUp(): Boolean {
        val controller = this.findNavController(R.id.fragmentContainerView)
        return controller.navigateUp()

    }
}