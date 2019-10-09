package github.ariefannur.mvicourutine.core.domain.action

sealed class MovieAction : Action{
    object GetPopularAction : MovieAction()
}

data class GetMovieAction(
    val dateStart:String,
    val dateEnd:String
) : MovieAction()


data class GetDetailMovieAction(
    val id:Int
) : MovieAction()