package github.ariefannur.mvicourutine.core.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
 @SerializedName("popularity") val popularity:Float,
 @SerializedName("poster_path") val posterPath:String,
 @SerializedName("backdrop_path") val backdropPath:String,
 @SerializedName("title") val title:String,
 @SerializedName("vote_average") val vote:Float,
 @SerializedName("overview") val overview:String

)