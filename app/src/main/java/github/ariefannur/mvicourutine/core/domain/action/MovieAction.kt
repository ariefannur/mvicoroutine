package github.ariefannur.mvicourutine.core.domain.action

sealed class MovieAction : Action{
    object GetMovieAction : MovieAction()
}