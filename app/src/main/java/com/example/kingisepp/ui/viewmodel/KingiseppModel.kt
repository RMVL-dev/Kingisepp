package com.example.kingisepp.ui.viewmodel

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.kingisepp.items.Attractrion

data class KingiseppModel(
    val currentList: List<Attractrion>,
    @DrawableRes val topBarImage: Int,
    @StringRes val topBarText: Int,
    val isShowingList: Boolean
)
