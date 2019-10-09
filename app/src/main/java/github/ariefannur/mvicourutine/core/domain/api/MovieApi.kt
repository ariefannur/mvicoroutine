package github.ariefannur.mvicourutine.core.domain.api

import github.ariefannur.mvicourutine.core.domain.model.Movie
import github.ariefannur.mvicourutine.core.domain.model.ResultMovie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi{

    @GET("trending/movie/week")
    suspend fun getPopularMovie() : ResultMovie

    @GET("discover/movie")
    suspend fun getNewestMovie(
                               @Query("primary_release_date.gt") startDate:String,
                               @Query("primary_release_date.lte") endDate:String
                               ) : ResultMovie

    @GET("movie/{id}")
    suspend fun getDetailMovie(@Path("id") id:Int) : Movie


}