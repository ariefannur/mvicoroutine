package github.ariefannur.mvicourutine.core.di

import github.ariefannur.mvicourutine.core.data.viewmodel.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModul = module{

    viewModel {
        MovieViewModel(get())
    }
}