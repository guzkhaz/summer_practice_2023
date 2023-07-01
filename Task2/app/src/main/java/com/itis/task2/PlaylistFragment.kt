package com.itis.task2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.task2.databinding.FragmentPlaylistBinding


class PlaylistFragment : Fragment(R.layout.fragment_playlist) {

    private var binding: FragmentPlaylistBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPlaylistBinding.bind(view)

       val name = arguments?.getString("ARG_NAME")
        Snackbar.make(binding!!.root, name!!, Snackbar.LENGTH_LONG).show()

       binding!!.btnToMusic.setOnClickListener {
           findNavController().navigate(R.id.action_playlistFragment_to_musicFragment)
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}