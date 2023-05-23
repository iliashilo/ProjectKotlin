package com.example.projectkotlin.presentation.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectkotlin.R
import com.example.projectkotlin.data.local.CardsDC
import com.example.projectkotlin.databinding.FirstFragmBinding
import com.example.projectkotlin.presentation.second.SecondImagesFragment

class FirstImagesFragment : Fragment(), FirstImagesAdapter.Listener {

    private var _binding: FirstFragmBinding? = null
    private val binding get() = _binding!!
    var cards = ArrayList<CardsDC>()

    lateinit var adapter: FirstImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cardData = listOf(
            CardsDC("Random photo 1 of dogs"),
            CardsDC("Random photo 2 of dogs"),
            CardsDC("Random photo 3 of dogs"),
            CardsDC("Random photo 4 of dogs"),
            CardsDC("Random photo 5 of dogs")
        )

        addImages(cardData)

        adapter = FirstImagesAdapter(this)
        adapter.setListOfAnimals(cards)
    }

    private fun addImages(cardData: List<CardsDC>) {
        cards.clear()

        for (i in cardData) {
            cards.add(i)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstFragmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(i: Int) {

        val bundle = bundleOf(
            SecondImagesFragment.numberInArray to i,
            SecondImagesFragment.name to cards[i].descOnCard
        )
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)

    }


}


