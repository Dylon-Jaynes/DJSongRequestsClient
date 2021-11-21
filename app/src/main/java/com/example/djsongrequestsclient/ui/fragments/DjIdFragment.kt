package com.example.djsongrequestsclient.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.djsongrequestsclient.R
import com.example.djsongrequestsclient.databinding.FragmentDjIdBinding
import com.example.djsongrequestsclient.ui.viewModels.DjIdViewModel

class DjIdFragment: Fragment() {

    private var _binding: FragmentDjIdBinding? = null
    // This property is only valid between onCreateView and onDestroyView
    private val binding get()= _binding!!
    private lateinit var viewModel: DjIdViewModel

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

        viewModel = ViewModelProvider(this)[DjIdViewModel::class.java]

        viewModel.dbResponseMessage.observe(viewLifecycleOwner, Observer { it ->
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })

        binding.buttonNext.setOnClickListener {
            viewModel.findDjById(binding.editTextEnterDjId.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        //hide action bar from splash screen
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }
}