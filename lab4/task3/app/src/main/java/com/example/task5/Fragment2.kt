package com.example.task5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.task5.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = Fragment2Binding.inflate(layoutInflater)
        val navController = findNavController()
        binding.bnToFirst.setOnClickListener {
            navController.navigate(R.id.action_fragment2_to_fragment1)
        }
        binding.bnToThird.setOnClickListener {
            navController.navigate(R.id.action_fragment2_to_fragment3)
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