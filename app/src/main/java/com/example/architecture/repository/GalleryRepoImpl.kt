package com.example.architecture.repository

import com.example.architecture.R

class GalleryRepoImpl : GalleryRepository {
    private var galList : List<Gallery>  = listOf(

    )
    override fun getGallery(): List<Gallery> {
        return galList.ifEmpty { getRemoteGallery() }
    }
    private fun getRemoteGallery() : List<Gallery>{
        val list : MutableList<Gallery> = mutableListOf(
            Gallery(0, R.string.photo_1, R.drawable.img , R.string.desc_1),
            Gallery(1, R.string.photo_2, R.drawable.img_1 , R.string.desc_2),
            Gallery(2, R.string.photo_3, R.drawable.img_2 , R.string.desc_3),
            Gallery(2, R.string.photo_4, R.drawable.img_3 , R.string.desc_4),
            Gallery(2, R.string.photo_5, R.drawable.img_4 , R.string.desc_5),
        )
        galList = list
        return list
    }
}