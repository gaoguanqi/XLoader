package com.maple.ximageloader

import android.content.Context

/**
 * author: gaogq
 * time: 2019/4/11 9:31
 * description:
 */
interface BaseImageLoaderStrategy<in T : ImageConfig> {
    fun loadImage(ctx:Context,config:T)
}