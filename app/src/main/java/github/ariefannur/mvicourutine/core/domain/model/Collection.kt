package github.ariefannur.mvicourutine.core.domain.model

import com.google.gson.annotations.SerializedName

data class Collection (
    @SerializedName("poster_path") val posterPath:String,
    @SerializedName("backdrop_path") val backdropPath: String
)