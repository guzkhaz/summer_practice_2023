package com.itis.task3

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.itis.task3.databinding.ItemAlbumBinding

class AlbumItem(
    private val binding: ItemAlbumBinding,
    private val glide: RequestManager,
    private val onItemClick: (Album) -> Unit
) : ViewHolder(binding.root) {

    fun onBind(album: Album){
        binding.run{
            tvTitle.text = album.name
            tvDesc.text = album.year

            glide
                .load(album.url)
                .into(ivImage)

            root.setOnClickListener{
                onItemClick(album)
            }
        }
    }
}