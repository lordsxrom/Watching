package com.electrics.watching.presentation.screens.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.electrics.watching.databinding.SearchFragmentBinding
import com.electrics.watching.domain.models.SearchItem
import com.electrics.watching.presentation.adapters.FilmsAdapter
import com.electrics.watching.presentation.adapters.OnInteractionListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchFragmentBinding.inflate(inflater, container, false)

        val adapter = FilmsAdapter(object : OnInteractionListener {

            override fun onClick(search: SearchItem) {
                viewModel.click(search)
            }
        })

        binding.rvSearches.adapter = adapter

        viewModel.searchList.observe(viewLifecycleOwner, { search ->
            adapter.submitList(search)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editQuery.addTextChangedListener {
            viewModel.searchShow(binding.editQuery.text.toString())
        }
    }

    fun search(query: MutableLiveData<String>) {
        if (query.value?.isNotEmpty() == true) {
            viewModel.searchShow(query.value.orEmpty())
        } else {
            Log.d("SearchFragment", "search, query is empty")
        }
    }
}