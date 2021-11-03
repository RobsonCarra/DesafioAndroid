package br.com.alura.ceep.ui.desafioandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.ceep.ui.desafioandroid.repository.ExamRepository
import br.com.alura.ceep.ui.desafioandroid.domain.Exam
import br.com.alura.ceep.ui.desafioandroid.helpers.Res
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

open class ExamViewModel(private val examRepository: ExamRepository) : ViewModel() {
    val list = MutableLiveData<List<Exam>>()
    val error = MutableLiveData<Exception>()

    fun getAll() {
        viewModelScope.launch {
            examRepository.getAll().collect { result ->
                when (result) {
                    is Res.Success -> list.postValue(result.items as List<Exam>)
                    is Res.Failure -> error.postValue(result.exception)
                }
            }
        }
    }
}