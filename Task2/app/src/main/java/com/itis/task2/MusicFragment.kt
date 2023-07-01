package com.itis.task2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.task2.databinding.FragmentMusicBinding

class MusicFragment : Fragment(R.layout.fragment_music) {

    private var binding: FragmentMusicBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)

        binding?.run {
            btnToPlaylist.setOnClickListener(){
                val bundle = Bundle()
                bundle.putString("ARG_NAME", "From Music Fragment")
                findNavController().navigate(
                    R.id.action_musicFragment_to_playlistFragment,
                    bundle
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}