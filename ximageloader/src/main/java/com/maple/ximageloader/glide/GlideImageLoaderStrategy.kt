package com.maple.ximageloader.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.maple.ximageloader.BaseImageLoaderStrategy
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * author: gaogq
 * time: 2019/4/11 10:10
 * description:
 */
class GlideImageLoaderStrategy : BaseImageLoaderStrategy<GlideImageConfig>{
    override fun loadImage(ctx: Context, config: GlideImageConfig) {
        val options = RequestOptions()
        options.placeholder(config.placeholder)
        options.error(config.errorPic)

        if(config.overWidth > 0 && config.overHeight > 0){
            options.override(config.overWidth,config.overHeight)
        }

        when(config.type){
            TransType.NORMAL-> loadCommon(ctx,options,config)
            TransType.GIF-> loadGif(ctx,options,config)
            TransType.CIRCLE-> loadCircle(ctx,options,config)
            TransType.ROUND-> loadRound(ctx,options,config)
            TransType.BLUR-> loadBlur(ctx,options,config)
            TransType.CIRCLE_ANR_BLUR-> loadCircleAndBlur(ctx,options,config)
        }
    }



    private fun loadCommon(ctx: Context, options:RequestOptions,config: GlideImageConfig){
        Glide.with(ctx)
            .load(config.any)
            .apply(options)
            .into(config.imageView)
    }

    private fun loadGif(ctx: Context, options:RequestOptions,config: GlideImageConfig){
        Glide.with(ctx)
            .asGif()
            .load(config.any)
            .apply(options)
            .into(config.imageView)
    }


    private fun loadCircle(ctx: Context, options:RequestOptions,config: GlideImageConfig){
        options.transform(CircleCrop())
        Glide.with(ctx)
            .load(config.any)
            .apply(options)
            .into(config.imageView)
    }


    private fun loadRound(ctx: Context, options:RequestOptions,config: GlideImageConfig){
        if(config.valueRound <= 0){
            config.valueRound = 10
        }
        options.transform(RoundedCornersTransformation(config.valueRound,config.valueRound))
        Glide.with(ctx)
            .load(config.any)
            .apply(options)
            .into(config.imageView)
    }


    private fun loadBlur(ctx: Context, options:RequestOptions,config: GlideImageConfig){
        if(config.valueBlur <= 0){
            config.valueBlur = 6
        }
        options.transform(BlurTransformation(config.valueBlur))
        Glide.with(ctx)
            .load(config.any)
            .apply(options)
            .into(config.imageView)
    }

    private fun loadCircleAndBlur(ctx: Context, options:RequestOptions,config: GlideImageConfig){
        if(config.valueBlur <= 0){
            config.valueBlur = 6
        }
        options.transform(MultiTransformation(CircleCrop(),BlurTransformation(config.valueBlur)))
        Glide.with(ctx)
            .load(config.any)
            .apply(options)
            .into(config.imageView)
    }


}