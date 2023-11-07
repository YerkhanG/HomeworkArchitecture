package com.example.architecture.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecture.GalleryAdapter
import com.example.architecture.databinding.GalleryListFragmentBinding
import com.example.architecture.repository.Gallery

class GalleryMVPFragment : Fragment() , GalleryScreen.View {
    private lateinit var binding : GalleryListFragmentBinding
    private val adapter : GalleryAdapter = GalleryAdapter()
    private lateinit var presenter : GalleryScreen.Presenter


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
        presenter = GalleryPresenter(this)

        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = adapter
        adapter.click={
            presenter.openDetails(it)
        }
    }
    override fun showData(list: List<Gallery>) {
        adapter.submitList(list)
    }
}