package com.example.djsongrequestsclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.djsongrequestsclient.R
import com.example.djsongrequestsclient.databinding.FragmentDjIdBinding

class DjIdFragment: Fragment() {

    private var _binding: FragmentDjIdBinding? = null
    // This property is only valid between onCreateView and onDestroyView
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDjIdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.next_destination)
        }
    }

    override fun onStart() {
        super.onStart()
        //hide action bar from splash screen
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }
}