package com.example.architecture.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecture.GalleryAdapter
import com.example.architecture.databinding.GalleryListFragmentBinding
import com.example.architecture.mvp.GalleryPresenter
import com.example.architecture.mvp.GalleryScreen
import com.example.architecture.repository.Gallery
import com.example.architecture.repository.GalleryRepoImpl

class GalleryMVVMFragment: Fragment(){
    private lateinit var binding : GalleryListFragmentBinding
    private val adapter : GalleryAdapter = GalleryAdapter()
    private val viewModel : GalleryViewModel = GalleryViewModel(GalleryRepoImpl())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GalleryListFragmentBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = adapter
        adapter.click={

        }
        viewModel.galleryListLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

}