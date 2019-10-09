package github.ariefannur.mvicourutine.core.domain.state

import com.google.gson.annotations.SerializedName
import github.ariefannur.mvicourutine.core.domain.model.Movie

data class ViewStateMovie(
    val isLoading: Boolean = false,
    @SerializedName("results")
    val movies: List<Movie> = emptyList(),
    val error: String? = null
)


data class ViewStateMovieDetail(
    val isLoading: Boolean = false,
    val movies: Movie? = null,
    val error: String? = null
)
