package com.example.navigationcomponentdemo.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions
import com.example.navigationcomponentdemo.R
import com.example.navigationcomponentdemo.databinding.FragmentBoxBinding
import kotlin.random.Random

class BoxFragment :Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding

    private val args: BoxFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        val color = args.color
        binding.root.setBackgroundColor(color)

        binding.btnGoBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnOpenSecret.setOnClickListener {
            findNavController().navigate(
                BoxFragmentDirections.actionBoxFragmentToSecretFragment(),
                navOptions {
                    anim {
                        enter = R.anim.second_enter
                        popEnter = R.anim.second_pop_enter
                    }
                }
            )
        }
        binding.btnGenerateNumber.setOnClickListener {
            val number = Random.nextInt(100)
            findNavController().previousBackStackEntry?.savedStateHandle?.set(EXTRA_RANDOM_NUMBER, number)
            findNavController().popBackStack()
        }
    }

    companion object {
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}