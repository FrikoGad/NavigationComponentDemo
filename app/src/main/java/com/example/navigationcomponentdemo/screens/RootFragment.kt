package com.example.navigationcomponentdemo.screens

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.navigationcomponentdemo.R
import com.example.navigationcomponentdemo.databinding.FragmentRootBinding
import com.example.navigationcomponentdemo.listenResult

class RootFragment : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)
        binding.btnOpenYellowBox.setOnClickListener {
            openBox(Color.rgb(251, 219, 28), getString(R.string.yellow))
        }
        binding.btnOpenGreenBox.setOnClickListener {
            openBox(Color.rgb(45, 154, 13), getString(R.string.green))
        }

        listenResult<Int>(BoxFragment.EXTRA_RANDOM_NUMBER) { randomNumber ->
            Toast.makeText(
                requireContext(),
                "${getString(R.string.generated_number)} $randomNumber",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun openBox(color: Int, colorName: String) {

        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(color, colorName)

        findNavController().navigate(
            direction,
            navOptions {
                anim {
                    enter = R.anim.enter
                    popEnter = R.anim.pop_enter
                }
            }
        )
    }

}