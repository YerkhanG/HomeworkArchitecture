package com.example.architecture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.databinding.ItemGalleryBinding
import com.example.architecture.repository.Gallery


class GalleryAdapter : ListAdapter<Gallery, GalleryAdapter.GalleryViewHolder>(GalleryUtils) {
    var click: ((Gallery) -> Unit)? = null
    object GalleryUtils: DiffUtil.ItemCallback<Gallery>() {
        override fun areItemsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Gallery, newItem: Gallery): Boolean {
            return oldItem == newItem
        }
    }
    inner class GalleryViewHolder(private val binding : ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Gallery) {
            binding.title.text = itemView.context.getString(item.title)
            binding.photo.setImageResource(item.photo)

            itemView.setOnClickListener {
                click?.invoke(item)
            }

        }
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

}