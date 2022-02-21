package com.electrics.watching.presentation.screens.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.electrics.watching.databinding.MovieInfoFragmentBinding

class MovieInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MovieInfoFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}