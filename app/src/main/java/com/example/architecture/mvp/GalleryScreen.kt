package com.example.architecture.mvp

import com.example.architecture.repository.Gallery

sealed interface GalleryScreen{
    interface View{
        fun showData(list : List<Gallery>)
    }
    interface Presenter{
        fun getData()
        fun openDetails(gal : Gallery)
    }
}