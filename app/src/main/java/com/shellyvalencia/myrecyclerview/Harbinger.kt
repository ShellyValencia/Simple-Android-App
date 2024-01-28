package com.shellyvalencia.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Harbinger(
    var name: String,
    var codename: String,
    var photo: Int,
    var description: String
) : Parcelable