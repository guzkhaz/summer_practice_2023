package com.itis.task3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.itis.task3.databinding.ItemAlbumBinding

class AlbumAdapter(
        private val list: List<Album>,
        private val glide: RequestManager,
        private val onItemClick: (Album) -> Unit
        ) : RecyclerView.Adapter<AlbumItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): AlbumItem =
        AlbumItem(
            binding =  ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onItemClick = onItemClick
        )

    override fun onBindViewHolder(holder: AlbumItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}