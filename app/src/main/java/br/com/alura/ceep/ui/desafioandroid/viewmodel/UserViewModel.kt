package br.com.alura.ceep.ui.desafioandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.ceep.ui.desafioandroid.repository.Repository
import br.com.alura.ceep.ui.desafioandroid.domain.User
import br.com.alura.ceep.ui.desafioandroid.helpers.Res
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

open class UserViewModel(private val repository: Repository) : ViewModel() {
    val list = MutableLiveData<List<User>>()
    val error = MutableLiveData<Exception>()

    fun getAll() {
        viewModelScope.launch {
            repository.getAll().collect { result ->
                when (result) {
                    is Res.Success -> list.postValue(result.items as List<User>)
                    is Res.Failure -> error.postValue(result.exception)
                }
            }
        }
    }
}