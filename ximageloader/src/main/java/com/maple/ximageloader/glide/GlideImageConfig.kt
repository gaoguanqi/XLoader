package com.maple.ximageloader.glide

import android.widget.ImageView
import com.maple.ximageloader.ImageConfig
import com.maple.ximageloader.R

/**
 * author: gaogq
 * time: 2019/4/11 10:10
 * description:
 */
class GlideImageConfig :ImageConfig{

    var overWidth:Int = 0
    var overHeight:Int = 0

    var valueBlur:Int = 0
    var valueRound:Int = 0

    var type:TransType = TransType.NORMAL

    constructor(any:Any,imageView:ImageView,placeholder:Int = R.drawable.ic_default_placeholder,errorPic:Int = R.drawable.ic_default_errorpic){
            this.any = any
            this.imageView = imageView
            this.placeholder = placeholder
            this.errorPic = errorPic
    }






}