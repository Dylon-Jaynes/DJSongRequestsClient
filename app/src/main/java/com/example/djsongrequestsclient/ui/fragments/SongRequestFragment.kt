package com.example.djsongrequestsclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.djsongrequestsclient.databinding.FragmentSongRequestBinding

class SongRequestFragment: Fragment() {

    private var _binding: FragmentSongRequestBinding? = null
    // This property is only valid between onCreateView and onDestroyView
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSongRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //hide action bar from splash screen
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }
}