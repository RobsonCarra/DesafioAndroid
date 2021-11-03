package br.com.alura.ceep.ui.desafioandroid.viewmodel.config

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.alura.ceep.ui.desafioandroid.repository.ExamRepository
import br.com.alura.ceep.ui.desafioandroid.viewmodel.ExamViewModel

class ExamViewModelFactory(
    private val examRepository: ExamRepository,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExamViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExamViewModel(examRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}