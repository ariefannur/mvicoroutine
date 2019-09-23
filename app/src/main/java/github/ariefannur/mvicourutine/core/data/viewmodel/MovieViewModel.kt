package github.ariefannur.mvicourutine.core.data.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import github.ariefannur.mvicourutine.BuildConfig
import github.ariefannur.mvicourutine.core.base.BaseViewModel
import github.ariefannur.mvicourutine.core.domain.api.MovieApi
import github.ariefannur.mvicourutine.core.domain.model.Movie
import github.ariefannur.mvicourutine.core.utils.launchSafely
import kotlinx.coroutines.GlobalScope

class MovieViewModel(val api:MovieApi) : BaseViewModel(){

    val movieLiveData = MutableLiveData<List<Movie>>()

    fun getMovie(){
        GlobalScope.launchSafely(job + uiDispatcher,{
            Log.d("AF", "this is error ")
        }){
            val movieResult = api.getPopularMoview(BuildConfig.API_KEY, "popularity.desc")
            if(movieResult.results.isNotEmpty()){
                movieLiveData.value = movieResult.results
            }else{

            }
        }
    }
}