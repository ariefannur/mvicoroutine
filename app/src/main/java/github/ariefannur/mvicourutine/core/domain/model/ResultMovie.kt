package github.ariefannur.mvicourutine.core.domain.model

import com.google.gson.annotations.SerializedName

data class ResultMovie(
    @SerializedName("page") val page:Int,
    @SerializedName("total_pages") val totalPages:Int,
    @SerializedName("results") val results:List<Movie>
)