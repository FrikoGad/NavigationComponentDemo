package com.example.navigationcomponentdemo.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentdemo.R
import com.example.navigationcomponentdemo.databinding.FragmentSecretBinding

class SecretFragment :Fragment(R.layout.fragment_secret) {

    private lateinit var binding: FragmentSecretBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)

        binding.btnCloseBox.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment, false)
        }
        binding.btnGoBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}