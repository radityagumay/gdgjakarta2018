package com.radityalabs.gdgjakarta.nullability

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonKotlin(
    val name: String,
    val address: String
) : Parcelable