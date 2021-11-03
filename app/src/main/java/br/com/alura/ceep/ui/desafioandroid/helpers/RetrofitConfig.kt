package br.com.alura.ceep.ui.desafioandroid.helpers

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun getClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()).build()
                    // toda chamada que passa por aqui é verificada pelo auth interceptor
//                    .addInterceptor(AuthInterceptor(context))
                    // authenticar automaticamente recebe a chamada de 401 e trata de acordo com o que dentro dele
//                    .authenticator(TokenAuthenticator())
//            )

    }
}