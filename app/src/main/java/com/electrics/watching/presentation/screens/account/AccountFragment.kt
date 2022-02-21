package com.electrics.watching.presentation.screens.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.electrics.watching.databinding.AccountFragmentBinding

class AccountFragment : Fragment() {

    private lateinit var binding: AccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AccountFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}