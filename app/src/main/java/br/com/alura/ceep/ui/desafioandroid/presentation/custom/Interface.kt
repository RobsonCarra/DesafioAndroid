package br.com.alura.ceep.ui.desafioandroid.presentation.custom

import br.com.alura.ceep.ui.desafioandroid.domain.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Interface {
    @GET(GET_ALL)
    fun getAll(): Deferred<Response<List<User>>>

//    @GET("v1/results/")
//    fun getByUid(@Path("id") id: String): Deferred<Response<User>>

    companion object {
        const val GET_ALL = "v1/results/"
    }
}