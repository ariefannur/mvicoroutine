package github.ariefannur.mvicourutine.core.domain.state

import github.ariefannur.mvicourutine.core.domain.model.Movie

sealed class StateMovie {
    object Loading : StateMovie()
    data class Success(val data: List<Movie>) : StateMovie()
    data class Error(val message: String?) : StateMovie()
}


sealed class StateMovieDetail {
    object Loading : StateMovieDetail()
    data class Success( val data: Movie) : StateMovieDetail()
    data class Error(val message: String?) : StateMovieDetail()
}