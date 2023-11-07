package com.example.architecture.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.repository.Gallery
import com.example.architecture.repository.GalleryRepository

class GalleryViewModel(
    private var repository : GalleryRepository
): ViewModel() {
    private var _galleryListLiveData = MutableLiveData<List<Gallery>>()
    var galleryListLiveData: LiveData<List<Gallery>> = _galleryListLiveData
    init{
        getData()
    }

    private fun getData(){
        val data = repository.getGallery()
        _galleryListLiveData.postValue(data)
    }
}