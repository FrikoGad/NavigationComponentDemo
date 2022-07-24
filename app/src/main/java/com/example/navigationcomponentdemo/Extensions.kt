package com.example.navigationcomponentdemo

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

typealias ResultListener<T> =(T) -> Unit

fun <T> Fragment.listenResult(key: String, listener: ResultListener<T>) {
    val liveData = findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)
    liveData?.observe(viewLifecycleOwner) { result ->
        if (result != null) {
            listener(result)
            liveData.value = null
        }
    }
}