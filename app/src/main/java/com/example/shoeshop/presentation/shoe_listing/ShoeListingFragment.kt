package com.example.shoeshop.presentation.shoe_listing

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentShoeListingBinding
import com.example.shoeshop.databinding.ShoeItemBinding
import com.example.shoeshop.presentation.ShoeListViewModel


class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        binding.lifecycleOwner = this
        binding.shoeListViewModel = shoeListViewModel
        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (item in it) {
                val shoeBinding: ShoeItemBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, container, false)
                shoeBinding.shoeItem = item
                binding.linerLayout.addView(shoeBinding.root)

            }
        })
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailsFragment())
        }
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailsFragment())
        return true
    }


}