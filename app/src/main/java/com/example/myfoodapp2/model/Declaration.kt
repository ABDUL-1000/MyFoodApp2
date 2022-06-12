package com.example.myfoodapp2.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Declaration (@DrawableRes val imageResources: Int, val name: String, val price: String, @StringRes val details: Int)



