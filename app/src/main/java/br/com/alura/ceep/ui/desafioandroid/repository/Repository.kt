package br.com.alura.ceep.ui.desafioandroid.repository

import br.com.alura.ceep.ui.coffemachine.exceptions.BadGatewayException
import br.com.alura.ceep.ui.coffemachine.exceptions.BadRequestException
import br.com.alura.ceep.ui.coffemachine.exceptions.NoContentException
import br.com.alura.ceep.ui.coffemachine.exceptions.NotFoundException
import br.com.alura.ceep.ui.desafioandroid.domain.User
import br.com.alura.ceep.ui.desafioandroid.helpers.Res
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import java.lang.Exception
import java.net.HttpURLConnection

class Repository (private val client: Retrofit){
    suspend fun getAll() = flow {
        val api = client.create(Interface::class.java)
        val req = api.getAll()
        val res = req.await()
        when (res.code()) {
            HttpURLConnection.HTTP_OK -> emit(Res.Success(res.body() as List<User>))
            HttpURLConnection.HTTP_NOT_FOUND -> emit(Res.Failure(NotFoundException()))
            HttpURLConnection.HTTP_BAD_REQUEST -> emit(Res.Failure(BadRequestException()))
            HttpURLConnection.HTTP_BAD_GATEWAY -> emit(Res.Failure(BadGatewayException()))
            HttpURLConnection.HTTP_NO_CONTENT -> emit(Res.Failure(NoContentException()))
            else -> emit(Res.Failure(Exception("Erro Generico")))
        }
        // when (res.code()) {
        //   HttpURLConnection.HTTP_OK -> emit(res.body())
        //   HttpURLConnection.HTTP_NOT_FOUND -> emit("Usuario nao encontrado")
        //   HttpURLConnection.HTTP_BAD_REQUEST -> emit("Erro de request")
        //   HttpURLConnection.HTTP_BAD_GATEWAY -> emit("Erro de servidor")
        //   HttpURLConnection.HTTP_NO_CONTENT -> emit("Dados nao encontrados")
        //   else -> emit("Erro Generico")
        // }
    }

//    suspend fun getByUid(uid: String) = flow {
//        val api = client.create(Interface::class.java)
//        val req = api.getByUid(uid)
//        val res = req.await()
//        when (res.code()) {
//            HttpURLConnection.HTTP_OK -> emit(Res.Success(res.body()))
//            HttpURLConnection.HTTP_NOT_FOUND -> emit(Res.Failure(NotFoundException("Usuário não encontrado")))
//            HttpURLConnection.HTTP_BAD_REQUEST -> emit(Res.Failure(BadRequestException()))
//            HttpURLConnection.HTTP_BAD_GATEWAY -> emit(Res.Failure(BadGatewayException()))
//            HttpURLConnection.HTTP_NO_CONTENT -> emit(Res.Failure(NoContentException()))
//            else -> emit(Res.Failure(Exception("Erro Generico")))
//        }
//    }
}