package com.cret.kakaoimagesearch

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cret.kakaoimagesearch.RecyclerViewAdapter.SearchResultViewHolder
import com.cret.kakaoimagesearch.databinding.SearchItemBinding
import com.cret.kakaoimagesearch.model.Document

class RecyclerViewAdapter(
    val context: Context?
) : ListAdapter<Document, SearchResultViewHolder>(DIFF) {

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

    class SearchResultViewHolder(private val binding: SearchItemBinding): RecyclerView.ViewHolder(binding.root){
        val thumbnailImage = binding.ivSearchImage
        val category = binding.tvSearchCategory
        val url = binding.tvSearchUrl
        val datetime = binding.tvSearchTime
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchResultViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return SearchResultViewHolder(SearchItemBinding.inflate(inflate, parent, false))
    }

    override fun onBindViewHolder(
        holder: SearchResultViewHolder,
        position: Int
    ) {
        val item = getItem(position)

        Glide.with(context!!).load(item.thumbnail_url)
            .fitCenter()
            .into(holder.thumbnailImage)
        holder.url.text = item.thumbnail_url
        holder.category.text = item.display_sitename
        holder.datetime.text = item.datetime
    }
}