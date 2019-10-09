package github.ariefannur.mvicourutine.core.utils

import android.widget.ImageView
import coil.api.load

const val BASE_THUMBNAIL = "http://image.tmdb.org/t/p/w185_and_h278_bestv2"
const val BASE_IMAGE = "http://image.tmdb.org/t/p/w600_and_h900_bestv2"

fun ImageView.displayThumbnail(url:String?){
    val thumbnailUrl = BASE_THUMBNAIL+url
    this.load(thumbnailUrl)
}

fun ImageView.display(url:String?){
    val validUrl = BASE_IMAGE+url
    this.load(validUrl){
        alpha = 0.8f
    }
}