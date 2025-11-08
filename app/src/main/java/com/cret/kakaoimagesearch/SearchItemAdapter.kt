package com.cret.kakaoimagesearch

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cret.kakaoimagesearch.model.Document

class SearchItemAdapter() : ListAdapter<Document, RecyclerView.ViewHolder>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<Document>() {
            override fun areItemsTheSame(
                oldItem: Document,
                newItem: Document
            ): Boolean {
                return oldItem.thumbnail_url == newItem.thumbnail_url
            }

            override fun areContentsTheSame(
                oldItem: Document,
                newItem: Document
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}