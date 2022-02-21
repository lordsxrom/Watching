package com.electrics.watching.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.electrics.watching.databinding.SearchHolderBinding
import com.electrics.watching.domain.models.SearchItem


interface OnInteractionListener {
    fun onClick(search: SearchItem) {}
}

class FilmsAdapter(
    private val onInteractionListener: OnInteractionListener
): ListAdapter<SearchItem, SearchViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val search = getItem(position)
        holder.bind(search)
    }
}

class SearchViewHolder(
    private val binding: SearchHolderBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(search: SearchItem) {
        binding.apply {
            movieTitle.text = search.show.name
            movieDescription.text = search.show.summary

            containerHolder.setOnClickListener {
                onInteractionListener.onClick(search)
            }
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<SearchItem>() {
    override fun areItemsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
        return oldItem.show.id == newItem.show.id
    }

    override fun areContentsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
        return oldItem == newItem
    }
}