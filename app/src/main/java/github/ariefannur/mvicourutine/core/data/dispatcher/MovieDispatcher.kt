package github.ariefannur.mvicourutine.core.data.dispatcher

import androidx.lifecycle.liveData
import github.ariefannur.mvicourutine.core.domain.action.GetDetailMovieAction
import github.ariefannur.mvicourutine.core.domain.action.GetMovieAction
import github.ariefannur.mvicourutine.core.domain.action.MovieAction
import github.ariefannur.mvicourutine.core.domain.api.MovieApi
import github.ariefannur.mvicourutine.core.domain.state.StateMovie
import github.ariefannur.mvicourutine.core.domain.state.StateMovieDetail

class MovieDispatcher(val api: MovieApi) {

    fun dispatchAction(action: MovieAction) = liveData{

        when(action){
            is MovieAction.GetPopularAction -> {
                emit(StateMovie.Loading)
                emit(getMovieApi())
            }
            is GetMovieAction -> {
                emit(StateMovie.Loading)
                emit(getMovieApiLattes(action.dateStart, action.dateEnd))
            }

            is GetDetailMovieAction -> {
                emit(StateMovieDetail.Loading)
                emit(getDetailMovie(action.id))
            }
        }

    }

    private suspend fun getMovieApi() : StateMovie{

            val result = api.getPopularMovie()
            if (result.results.isNotEmpty()) {
                return StateMovie.Success(data = result.results)
            }else {
                return StateMovie.Error(message = "error data")
            }

    }


    private suspend fun getMovieApiLattes(dateStart: String, dateEnd: String) : StateMovie{

        val result = api.getNewestMovie(dateStart, dateEnd)
        if (result.results.isNotEmpty()) {
            return StateMovie.Success(data = result.results)
        }else {
            return StateMovie.Error(message = "error data")
        }

    }

    private suspend fun getDetailMovie(id: Int) : StateMovieDetail{
        val result = api.getDetailMovie(id)
        if (result.title.isNotEmpty()) {
            return StateMovieDetail.Success(data = result)
        }else {
            return StateMovieDetail.Error(message = "error data")
        }
    }


}