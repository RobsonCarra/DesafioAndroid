package br.com.alura.ceep.ui.desafioandroid.repository

import br.com.alura.ceep.ui.desafioandroid.domain.Exam
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface Interface {
    @GET(GET_ALL)
    fun getAll(): Deferred<Response<List<Exam>>>

    companion object {
        const val GET_ALL = "v1/results/"
    }
}