package github.ariefannur.mvicourutine.core.base

import android.app.Application
import github.ariefannur.mvicourutine.core.di.networkModule
import github.ariefannur.mvicourutine.core.di.viewModelModul
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){

    private val modules = listOf(
        networkModule, viewModelModul
    )

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(modules)

        }

    }

}