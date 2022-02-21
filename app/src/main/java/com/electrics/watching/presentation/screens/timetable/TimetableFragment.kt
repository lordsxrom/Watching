package com.electrics.watching.presentation.screens.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.electrics.watching.databinding.TimetableFragmentBinding

class TimetableFragment : Fragment() {

    private lateinit var binding: TimetableFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TimetableFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}