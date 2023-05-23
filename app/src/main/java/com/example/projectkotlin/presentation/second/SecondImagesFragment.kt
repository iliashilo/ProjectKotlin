package com.example.projectkotlin.presentation.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.projectkotlin.databinding.SecondFragmBinding

class SecondImagesFragment: Fragment() {

    private var _binding: SecondFragmBinding? = null
    private val binding get() = _binding!!
    lateinit var secondViewModel: SecondImagesViewModel

    companion object {
        const val numberInArray = "number"
        const val name = "name"

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmBinding.inflate(inflater, container, false)
        secondViewModel = ViewModelProvider(this).get(SecondImagesViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = arguments?.getString(name)

        secondViewModel.getImage()
        secondViewModel.image.observe(viewLifecycleOwner) {
            Glide.with(view).load(it).fitCenter().into(binding.ivPhoto)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}