package com.electrics.watching.presentation.screens.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.electrics.watching.R
import com.electrics.watching.databinding.SearchFragmentBinding
import com.electrics.watching.domain.models.SearchItem
import com.electrics.watching.presentation.adapters.FilmsAdapter
import com.electrics.watching.presentation.adapters.OnInteractionListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.search_fragment) {

    private val binding : SearchFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = FilmsAdapter(object : OnInteractionListener {

            override fun onClick(search: SearchItem) {
                viewModel.click(search)
            }
        })

        binding.rvSearches.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.searchList
                .onEach { search ->
                    adapter.submitList(search)
                }
                .collect()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editQuery.addTextChangedListener {
            viewModel.searchShow(binding.editQuery.text.toString())
        }
    }
}