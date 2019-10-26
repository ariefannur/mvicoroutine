# mvicoroutine
mvi pattern with coroutine and koin dependency injection

## The Movie App
<img src="https://github.com/ariefannur/mvicoroutine/blob/master/assets/movie.gif" height="550em" />

### State
```kotlin
sealed class StateMovie {
    object Loading : StateMovie()
    data class Success(val data: List<Movie>) : StateMovie()
    data class Error(val message: String?) : StateMovie()
}
```
### Action
```kotlin
sealed class MovieAction : Action{
    object GetPopularAction : MovieAction()
}

data class GetMovieAction(
    val dateStart:String,
    val dateEnd:String
) : MovieAction()
```

### Dispather
```kotlin
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
```

### ViewModel
```kotlin
class MovieViewModel(val api:MovieApi) : BaseViewModel(){

val movieViewStatePopular = Transformations.map(movieDispatcher.dispatchAction(MovieAction.GetPopularAction)){
        when (it) {
            is StateMovie.Loading -> viewStateMovie.copy(isLoading = true)
            is StateMovie.Success -> viewStateMovie.copy(movies = it.data)
            is StateMovie.Error -> viewStateMovie.copy(error = it.message)
            else -> viewStateMovie.copy(error = "error")
        }
    }
}    
```



