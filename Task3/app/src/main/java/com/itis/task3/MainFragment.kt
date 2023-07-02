package com.itis.task3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.task3.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null
    private var adapter: AlbumAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter(){
        adapter = AlbumAdapter(AlbumRepository.list, Glide.with(this)
        ) { city ->
            run {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("ARG_ID", city.id)
                context?.startActivity(intent)
            }
        }
        binding?.rvAlbum?.adapter = adapter
    }
}