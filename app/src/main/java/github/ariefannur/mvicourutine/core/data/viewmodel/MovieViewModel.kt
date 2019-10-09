package github.ariefannur.mvicourutine.core.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import github.ariefannur.mvicourutine.core.base.BaseViewModel
import github.ariefannur.mvicourutine.core.data.dispatcher.MovieDispatcher
import github.ariefannur.mvicourutine.core.domain.action.GetDetailMovieAction
import github.ariefannur.mvicourutine.core.domain.action.GetMovieAction
import github.ariefannur.mvicourutine.core.domain.action.MovieAction
import github.ariefannur.mvicourutine.core.domain.api.MovieApi
import github.ariefannur.mvicourutine.core.domain.model.Movie
import github.ariefannur.mvicourutine.core.domain.state.StateMovie
import github.ariefannur.mvicourutine.core.domain.state.StateMovieDetail
import github.ariefannur.mvicourutine.core.domain.state.ViewStateMovie
import github.ariefannur.mvicourutine.core.domain.state.ViewStateMovieDetail

class MovieViewModel(val api:MovieApi) : BaseViewModel(){

    val movieDetailLiveData = MutableLiveData<Movie>()

    val movieDispatcher by lazy {
        MovieDispatcher(api)
    }

    private val viewStateMovie = ViewStateMovie()
    private val viewStateMovieLattes = ViewStateMovie()
    private val viewStateMovieDetail = ViewStateMovieDetail()

    val movieViewStatePopular = Transformations.map(movieDispatcher.dispatchAction(MovieAction.GetPopularAction)){
        when (it) {
            is StateMovie.Loading -> viewStateMovie.copy(isLoading = true)
            is StateMovie.Success -> viewStateMovie.copy(movies = it.data)
            is StateMovie.Error -> viewStateMovie.copy(error = it.message)
            else -> viewStateMovie.copy(error = "error")
        }
    }

    fun movieViewStateLattes(startDate: String, endDate: String) = Transformations.map(movieDispatcher.dispatchAction(
        GetMovieAction(dateStart = startDate, dateEnd = endDate)
    )){
        when (it) {
            is StateMovie.Loading -> viewStateMovieLattes.copy(isLoading = true)
            is StateMovie.Success -> viewStateMovieLattes.copy(movies = it.data)
            is StateMovie.Error -> viewStateMovieLattes.copy(error = it.message)
            else -> viewStateMovie.copy(error = "error")
        }
    }

    fun getDetailMovie(id:Int) = Transformations.map(movieDispatcher
        .dispatchAction(GetDetailMovieAction(id = id))) {
            when (it) {
                is StateMovieDetail.Loading -> viewStateMovieDetail.copy(isLoading = true)
                is StateMovieDetail.Success -> viewStateMovieDetail.copy(movies = it.data)
                is StateMovieDetail.Error -> viewStateMovieDetail.copy(error = it.message)
                else -> viewStateMovieDetail.copy(error = "error")
            }
    }
}