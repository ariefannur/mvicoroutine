package github.ariefannur.mvicourutine.feature.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import github.ariefannur.mvicourutine.R
import github.ariefannur.mvicourutine.core.base.BaseActivity
import github.ariefannur.mvicourutine.core.data.viewmodel.MovieViewModel
import github.ariefannur.mvicourutine.core.di.viewModelModul
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_main

    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieViewModel.getMovie()
        movieViewModel.movieLiveData.observe(this, Observer {
            Log.d("AF", "data ${it.size} ")
        })
    }


}
