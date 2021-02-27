package com.example.toyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.toyapp.database.ToyDatabase
import com.example.toyapp.databinding.FragmentToyDetailBinding

class ToyDetailFragment : Fragment() {

    private lateinit var viewModel: ToyDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentToyDetailBinding>(
            inflater,
            R.layout.fragment_toy_detail,
            container,
            false
        )



        return binding.root
    }
}