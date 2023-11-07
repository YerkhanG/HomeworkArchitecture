package com.example.architecture.mvp

import com.example.architecture.repository.Gallery
import com.example.architecture.repository.GalleryRepoImpl
import com.example.architecture.repository.GalleryRepository

class GalleryPresenter(
    private val view : GalleryScreen.View
) : GalleryScreen.Presenter {
    private val repository : GalleryRepository = GalleryRepoImpl()
    init{
        getData()
    }

    override fun getData() {
        val data = repository.getGallery()
        view.showData(data)
    }


    override fun openDetails(gal: Gallery) {
        TODO("Not yet implemented")
    }
}