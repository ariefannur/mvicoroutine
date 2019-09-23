package github.ariefannur.mvicourutine.core.di

import com.google.gson.Gson
import github.ariefannur.mvicourutine.BuildConfig
import github.ariefannur.mvicourutine.core.domain.api.MovieApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single { ProvideNetwork().provideService() }

}

class ProvideNetwork{

    private fun provideLogging() = HttpLoggingInterceptor().also {
        it.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    private fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val newUrl = chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()

            val newRequest = chain
                .request()
                .newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }.addInterceptor(provideLogging())

        .build()


    fun provideService():MovieApi{

        val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(MovieApi::class.java)

    }
}
