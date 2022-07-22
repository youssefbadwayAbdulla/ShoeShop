package com.example.shoeshop.presentation.shoe_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentShoeDetailsBinding
import com.example.shoeshop.domain.model.DetailsViewModel
import com.example.shoeshop.presentation.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var detailsViewModel: DetailsViewModel
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsViewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        binding.detailsViewModel = detailsViewModel
        binding.lifecycleOwner = this


        binding.add.setOnClickListener {
            val createNewShoe = detailsViewModel.makeShoe()
            shoeListViewModel.addItemShoe(createNewShoe)
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListingFragment())


        }
    }

}