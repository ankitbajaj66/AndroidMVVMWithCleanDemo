package com.example.practice.navigationgraph.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

/**
 *Created by Ankit Bajaj on 27-03-2020.
 */
@Parcelize
data class Money(val amount: BigDecimal) : Parcelable