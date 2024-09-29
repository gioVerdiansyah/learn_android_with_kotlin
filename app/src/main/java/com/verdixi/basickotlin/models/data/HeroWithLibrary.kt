package com.verdixi.basickotlin.models.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeroWithLibrary(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable