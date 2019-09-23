package github.ariefannur.mvicourutine.core.domain.api

import github.ariefannur.mvicourutine.core.domain.model.ResultMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi{

    @GET("discover/movie")
    suspend fun getPopularMoview(@Query("api_key") apiKey:String, @Query("sort_by") sortBy:String) : ResultMovie
}