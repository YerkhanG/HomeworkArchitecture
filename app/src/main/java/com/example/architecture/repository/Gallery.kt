package com.example.architecture.repository

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Gallery(
    val id : Int ,
    @StringRes
    val title : Int ,
    @DrawableRes
    val photo : Int ,
    @StringRes
    val description : Int
)
