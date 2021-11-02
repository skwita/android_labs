package com.example.task5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.task5.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = Fragment1Binding.inflate(layoutInflater)
        val navController = findNavController()
        binding.bnToSecond.setOnClickListener {
            navController.navigate(R.id.action_fragment1_to_fragment2)
        }
        binding.navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.to_about -> {
                    navController.navigate(R.id.global_about)
                }
            }
            false
        }
        return binding.root
    }
}