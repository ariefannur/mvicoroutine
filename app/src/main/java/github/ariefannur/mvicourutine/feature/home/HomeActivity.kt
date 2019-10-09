package github.ariefannur.mvicourutine.feature.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import github.ariefannur.mvicourutine.R
import github.ariefannur.mvicourutine.core.base.BaseActivity
import github.ariefannur.mvicourutine.core.data.viewmodel.MovieViewModel
import github.ariefannur.mvicourutine.core.domain.action.GetMovieAction
import github.ariefannur.mvicourutine.core.domain.action.MovieAction
import github.ariefannur.mvicourutine.core.domain.state.StateMovie
import github.ariefannur.mvicourutine.core.domain.state.ViewStateMovie
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.wait
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class HomeActivity : BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_main

    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rv_popular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_new.layoutManager = LinearLayoutManager(this)

        movieViewModel.movieViewStatePopular
            .observe(this, Observer {
            renderPopular(it)
        })


        val cal = Calendar.getInstance()
        cal.time = Date()
        val dateStart = "${cal.get(Calendar.YEAR)}-0${cal.get(Calendar.MONTH)}-01"
        val dateEnd = "${cal.get(Calendar.YEAR)}-0${cal.get(Calendar.MONTH)}-30"


        movieViewModel.movieViewStateLattes(dateStart, dateEnd)
            .observe(this, Observer {
            renderLattes(it)
        })

    }

    private fun renderPopular(it: ViewStateMovie){
        if (!it.isLoading && it.error == null) {
            rv_popular.adapter = AdapterPopularMovie(it.movies, false)
        }

        if (it.isLoading){

        }

    }

    private fun renderLattes(it: ViewStateMovie){
        if (!it.isLoading && it.error == null) {
            rv_new.adapter = AdapterPopularMovie(it.movies, true)
        }

        if (it.isLoading){

        }
    }


}
